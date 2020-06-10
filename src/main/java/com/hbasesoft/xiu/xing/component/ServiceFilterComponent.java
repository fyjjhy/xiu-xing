package com.hbasesoft.xiu.xing.component;

import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.framework.common.utils.ContextHolder;
import com.hbasesoft.framework.rule.core.FlowComponent;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.entity.ServFilterEntity;
import com.hbasesoft.xiu.xing.service.ServFilterService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @since V1.0<br>
 * @see  <br>
 */
@Component("ServiceFilterComponent")
public class ServiceFilterComponent implements FlowComponent<ServiceFlowBean> {

    private static final String PROCESS_ID = "H-Process-id";

    @Resource
    private ServFilterService servFilterService;

    private Map<String, Stack<ServiceFilterHandler>> serviceFilterStackMap = new HashMap<>();

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
        String processId = CommonUtil.getTransactionID();
        flowContext.setAttribute(PROCESS_ID, processId);

        List<ServFilterEntity> filterList = servFilterService.queryServFilter(flowBean.getCategory(), flowBean.getServCode(), flowBean.getAction());
        if (CollectionUtils.isNotEmpty(filterList)) {
            Stack<ServiceFilterHandler> stack = new Stack<>();
            ApplicationContext context = ContextHolder.getContext();
            for (ServFilterEntity entity : filterList) {
                Map<String, Object> paramMap = StringUtils.isNoneEmpty(entity.getConfigParams())
                    ? JSONObject.parseObject(entity.getConfigParams())
                    : new HashMap<>();
                ServiceFilter filter = context.getBean(entity.getFilterInstance(), ServiceFilter.class);

                if (!filter.before(flowBean, flowContext, paramMap)) {
                    return false;
                }
                stack.push(new ServiceFilterHandler(filter, paramMap));
            }
            serviceFilterStackMap.put(processId, stack);
        }
        return true;
    }

    /**
     * Description: <br>
     * 
     * @author 付永杰<br>
     * @taskId <br>
     * @param flowBean
     * @param flowContext
     * @param e
     * @throws Exception <br>
     */
    // @Override
    public void afterProcess(ServiceFlowBean flowBean, FlowContext flowContext, Exception e) throws Exception {
        String processId = flowContext.getAttribute(PROCESS_ID);
        try {
            Stack<ServiceFilterHandler> stack = serviceFilterStackMap.get(processId);
            if (CollectionUtils.isNotEmpty(stack)) {
                stack.forEach(holder -> {
                    holder.getServiceFilter().after(flowBean, flowContext, holder.getConfigParams(), e);
                });
            }
        }
        finally {
            serviceFilterStackMap.remove(processId);
        }
    }

}
