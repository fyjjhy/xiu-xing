package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.db.core.config.DbParam;
import com.hbasesoft.framework.db.core.utils.PagerList;
import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.Datasource;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.util.JdbcUtil;
import com.hbasesoft.xiu.xing.util.PagerListVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月27日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Component("SqlServiceComponent")
public class SqlServiceComponent implements FlowComponent<ServiceFlowBean> {

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
    @SuppressWarnings({
        "rawtypes", "unchecked"
    })
    @Override
    public boolean process(ServiceFlowBean flowBean, FlowContext flowContext) throws Exception {

        Datasource datasource = flowBean.getDatasource();
        String code = datasource.getCode();
        JdbcUtil jdbcUtil = JdbcUtil.getInstance(code, new DbParam(code, datasource.getUrl(),
                datasource.getName(), datasource.getPassword()));
        Map<String, Object> paramMap = new HashMap<>(flowBean.getRequest());
        paramMap.putAll(flowContext.getParamMap());
        Object result = jdbcUtil.executeSql(flowBean.getId(), flowBean.getServData().getDataScript(), paramMap);
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction()) && result instanceof PagerList) {
            PagerList list = (PagerList) result;
            PagerListVo vo = new PagerListVo();
            vo.setDatas(list);
            vo.setPageIndex(list.getPageIndex());
            vo.setPageSize(list.getPageSize());
            vo.setTotalSize(list.getTotalCount());
            result = vo;
        }
        else if (ServiceFlowBean.ACTION_GET.equals(flowBean.getAction()) && result instanceof List) {
            if(CollectionUtils.isNotEmpty((List) result)){
                result = ((List) result).get(0);
            }else{
                result = null;
            }
        }

        flowBean.setResponse(result);
        return true;
    }

}
