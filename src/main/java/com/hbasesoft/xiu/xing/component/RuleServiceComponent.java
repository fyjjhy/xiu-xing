package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
@Component("RuleServiceComponent")
public class RuleServiceComponent implements FlowComponent<ServiceFlowBean> {

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
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean process(ServiceFlowBean flowBean, FlowContext flowContext) throws Exception {
//        String ruleScript = flowBean.getServRule().getRuleScript();
//        if (StringUtils.isNotEmpty(ruleScript)) {
//            JSONObject ruleJson = JSONObject.parseObject(ruleScript);
//            Assert.notNull(ruleJson, ErrorCodeDef.FLOW_NOT_MATCH, bean);
//            FlowConfig config = JsonConfigUtil.getFlowConfig(ruleJson);
//            Assert.notNull(ruleJson, ErrorCodeDef.FLOW_NOT_MATCH, config);
//            FlowHelper.execute(bean, new FlowContext(config, flowContext.getExtendUtils(), flowContext.getParamMap()));
//        }
        return true;
    }

}
