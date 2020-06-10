package com.hbasesoft.xiu.xing.component;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;

import java.util.Map;

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
public interface ServiceFilter {

    default boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        return true;
    }

    default void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams,
                       Exception e) {
    }

}
