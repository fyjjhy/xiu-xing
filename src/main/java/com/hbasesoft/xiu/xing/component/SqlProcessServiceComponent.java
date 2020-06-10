package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.common.utils.engine.VelocityParseFactory;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.db.core.config.DbParam;
import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.Datasource;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.util.JdbcUtil;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description> SQL过程处理<br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月27日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Component("SqlProcessServiceComponent")
public class SqlProcessServiceComponent implements FlowComponent<ServiceFlowBean> {

    /**
     * Description: <br>
     * 
     * @author 付永杰<br>
     * @taskId <br>
     * @param flowBean
     * @param flowContext
     * @return
     * @throws Exception <br>
     */
    @Override
    public boolean process(ServiceFlowBean flowBean, FlowContext flowContext) throws Exception {

        Datasource datasource = flowBean.getDatasource();
        String code = datasource.getCode();
        JdbcUtil jdbcUtil = JdbcUtil.getInstance(code, new DbParam(code, datasource.getUrl(),
                datasource.getName(), datasource.getPassword()));

        Map<String, Object> context = new HashMap<>(flowBean.getRequest());
        context.put(JdbcUtil.CONTEXT_KEY, jdbcUtil);
        context.putAll(flowContext.getParamMap());

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DataSourceTransactionManager transactionManager = jdbcUtil.getTransactionManager();
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            String result = VelocityParseFactory.parse(flowBean.getId(), flowBean.getServData().getDataScript(), context);
            transactionManager.commit(status);
            result = result.replaceAll("\n|\r|\\(|\\)","");
            result = result.trim();
            flowBean.setResponse(result);
        }
        catch (Exception e) {
            transactionManager.rollback(status);
            LoggerUtil.error(e);
            throw e;
        }
        return true;
    }

}
