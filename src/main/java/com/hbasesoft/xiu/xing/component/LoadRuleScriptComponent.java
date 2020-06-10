/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import org.springframework.stereotype.Component;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @taskId <br>
 * @CreateDate 2020年05月27日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Component("LoadRuleScriptComponent")
public class LoadRuleScriptComponent implements FlowComponent<ServiceFlowBean> {

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
//        if (StringUtils.isEmpty(flowBean.getType())) {
//            ServRule platServiceRuleEntity = platConfigClient.getServiceRuleEntityByServId(flowBean.getId(),
//                flowBean.getAction());
//            if (platServiceRuleEntity != null) {
//                flowBean.setType(ServiceFlowBean.TYPE_RULE);
//                flowBean.setServRule(platServiceRuleEntity);
//            }
//        }
        return true;
    }

}
