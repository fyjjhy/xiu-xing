package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import org.springframework.stereotype.Component;

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
@Component("CheckServiceTypeComponent")
public class CheckServiceTypeComponent implements FlowComponent<ServiceFlowBean> {

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
        Assert.notEmpty(flowBean.getType(), XiuXingErrorCodeDef.SERVICE_NOT_FOUND);
        return true;
    }

}
