package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.Datasource;
import com.hbasesoft.xiu.xing.bean.ServData;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.service.DatasourceService;
import com.hbasesoft.xiu.xing.service.ServDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Component("LoadSqlScriptComponent")
public class LoadSqlScriptComponent implements FlowComponent<ServiceFlowBean> {

    @Resource
    private ServDataService servDataService;

    @Resource
    private DatasourceService datasourceService;

    /**
     * Description: <br>
     * 
     * @author 王伟<br>
     * @taskId <br>
     * @param flowBean
     * @param flowContext
     * @return
     * @throws Exception <br>
     */
    @Override
    public boolean process(ServiceFlowBean flowBean, FlowContext flowContext) throws Exception {
        if (StringUtils.isEmpty(flowBean.getType())) {
            ServData servData = servDataService.getServiceDataEntityByServId(flowBean.getId(), flowBean.getAction());
            if (servData != null) {
                flowBean.setServData(servData);
                String script = servData.getDataScript();
                flowBean.setType(script.indexOf("#sql") != -1 ? XiuXingCommonConstant.TYPE_SQL_PROCESS : XiuXingCommonConstant.TYPE_SQL);
                // 获取数据源配置
                Datasource datasource = datasourceService.getDatasourceEntityById(servData.getDatasourceId());

                flowBean.setDatasource(datasource);
            }
        }
        return true;
    }

}
