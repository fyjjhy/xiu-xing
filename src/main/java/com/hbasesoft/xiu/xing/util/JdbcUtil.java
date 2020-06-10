package com.hbasesoft.xiu.xing.util;

import com.hbasesoft.framework.common.ErrorCodeDef;
import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.framework.common.utils.engine.OgnlUtil;
import com.hbasesoft.framework.common.utils.engine.VelocityParseFactory;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.db.core.DaoConstants;
import com.hbasesoft.framework.db.core.DaoException;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.config.DbParam;
import com.hbasesoft.framework.db.core.utils.DataSourceUtil;
import com.hbasesoft.framework.db.core.utils.PagerList;
import com.hbasesoft.framework.db.core.utils.SQlCheckUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2017年10月2日 <br>
 * @since V1.0<br>
 * @see <br>
 */
public final class JdbcUtil {

    public static final String CONTEXT_KEY = "JdbcUtil";

    private static final String GENERATE_ID = "AUTO_ID";

    /**
     * 表示以：开头的合法变量名
     */
    private static final String REG_EX = ":[ tnx0Bfr]*[_a-zA-Z][_a-zA-Z.0-9]*";

    private static Map<String, JdbcUtil> utilInstance = new HashMap<>();

    /**
     * pat
     */
    private Pattern pat = Pattern.compile(REG_EX);

    private DataSourceTransactionManager transactionManager;

    private NamedParameterJdbcTemplate jdbcTemplate;

    private static ThreadLocal<Map<String, DataSourceTransactionManager>> threadLocal = new ThreadLocal<>();

    private JdbcUtil(String code, DbParam dbParam) {
        DataSource dataSource = DataSourceUtil.getDataSource(code);
        if (dataSource == null) {
            dataSource = DataSourceUtil.registDataSource(code, dbParam);
        }
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        Map<String, DataSourceTransactionManager> transactionManagerHolder = threadLocal.get();
        if (transactionManagerHolder == null) {
            transactionManagerHolder = new HashMap<>();
            threadLocal.set(transactionManagerHolder);
        }
        transactionManager = transactionManagerHolder.get(code);
        if (transactionManager == null) {
            transactionManager = new DataSourceTransactionManager(dataSource);
            transactionManagerHolder.put(code, transactionManager);
        }
    }

    public static JdbcUtil getInstance(String code, DbParam dbParam) {
        synchronized (utilInstance) {
            JdbcUtil jdbcUtil = utilInstance.get(code);
            if (jdbcUtil == null) {
                jdbcUtil = new JdbcUtil(code, dbParam);
                utilInstance.put(code, jdbcUtil);
            }
            return jdbcUtil;
        }
    }

    public DataSourceTransactionManager getTransactionManager() {
        return this.transactionManager;
    }

    public NamedParameterJdbcTemplate geJdbcTemplate() {
        return this.jdbcTemplate;
    }

    public Object executeSql(String code, String script, Map<String, Object> dataMap) {
        Map<String, Object> params = new HashMap<>();
        final String sql = prepareSql(code, script, params, dataMap);

        SQlCheckUtil.checkSql(sql);

        final String lowerCaseSql = StringUtils.trim(sql.toLowerCase());
        boolean query = lowerCaseSql.startsWith(DaoConstants.SQL_SELECT_PREFIX);

        TransactionTemplate transactionTemplate = new TransactionTemplate(getTransactionManager());
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        return transactionTemplate.execute((status) -> {
            try {
                if (query) {
                    // 处理分页
                    if (dataMap.containsKey(Param.PAGE_INDEX)) {
                        int pageIndex = Integer.parseInt(dataMap.get(Param.PAGE_INDEX).toString());
                        if (pageIndex <= 0) {
                            pageIndex = 1;
                        }

                        int pageSize = dataMap.containsKey(Param.PAGE_SIZE)
                            ? Integer.parseInt(dataMap.get(Param.PAGE_SIZE).toString())
                            : 10;
                        if (pageSize <= 0 || pageSize > 1000) {
                            pageSize = 10;
                        }

                        int orderByIndex = lowerCaseSql.lastIndexOf(" order by ");

                        StringBuilder pageScript = new StringBuilder().append("SELECT COUNT(1) FROM (")
                            .append(orderByIndex != -1 ? sql.substring(0, orderByIndex) : sql).append(") QUERY_DATA__");
                        long total = geJdbcTemplate().queryForObject(pageScript.toString(), params, Long.class);

                        PagerList<Map<String, Object>> list = new PagerList<>();
                        list.setPageIndex(pageIndex);
                        list.setPageSize(pageSize);
                        list.setTotalCount(total);
                        if (total > 0 && (pageIndex - 1) * pageSize < total) {
                            list.addAll(geJdbcTemplate().query(new StringBuilder().append(sql).append(" limit ")
                                .append((pageIndex - 1) * pageSize).append(',').append(pageSize).toString(), params,
                                new ColumnMapRowMapper()));
                        }
                        return list;
                    }
                    else {
                        return geJdbcTemplate().query(sql, params, new ColumnMapRowMapper());
                    }
                }
                else {
                    geJdbcTemplate().update(sql, params);
                    return params.get(GENERATE_ID);
                }
            }
            catch (Exception e) {
                status.setRollbackOnly();
                throw e;
            }
        });
    }

    /**
     * Description: 使用Velocity语法编译SQL<br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param code
     * @param script
     * @param params
     * @param dataMap
     * @return <br>
     */
    private String prepareSql(String code, String script, Map<String, Object> params, Map<String, Object> dataMap) {
        if (MapUtils.isNotEmpty(dataMap)) {
            script = VelocityParseFactory.parse(code, script, dataMap);
        }
        script = script.replaceAll("\\n", " ").replaceAll("\\t", " ").replaceAll("\\s{1,}", " ");

        Matcher m = pat.matcher(script);
        try {
            while (m.find()) {
                LoggerUtil.info(" Match [" + m.group() + "] at positions " + m.start() + "-" + (m.end() - 1));
                String ognl_key = m.group().replace(":", "").trim();

                if (GENERATE_ID.equals(ognl_key)) {
                    params.put(GENERATE_ID, CommonUtil.getTransactionID());
                }
                else {
                    params.put(ognl_key, OgnlUtil.getValue(ognl_key, dataMap));
                }

            }
            script = VelocityParseFactory.parse(code, script, params);

            // 处理like
            if (MapUtils.isNotEmpty(params) && (script.indexOf(" like ") != -1 || script.indexOf("LIKE") != -1)) {
                String lowerCaseLike = StringUtils.replaceAll(script, " LIKE ", " like ");
                for (Entry<String, Object> entry : params.entrySet()) {
                    String value = CommonUtil.getString(entry.getValue());
                    if (lowerCaseLike.indexOf(" like :" + entry.getKey()) != -1 && StringUtils.isNotEmpty(value)) {
                        entry.setValue('%' + value + '%');
                    }
                }
            }

        }
        catch (Exception e) {
            throw new DaoException(ErrorCodeDef.OGNL_ERROR_10009, e);
        }
        return script;
    }

}
