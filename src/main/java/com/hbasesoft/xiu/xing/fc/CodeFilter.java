package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.service.RenWuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月08日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CodeFilter")
public class CodeFilter implements ServiceFilter {

    @Resource
    private RenWuService renWuService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> request = flowBean.getRequest();
        if (request.containsKey(XiuXingCommonConstant.FUNC_MODEL_CODE)) {
            String funcModelCode = (String) request.get(XiuXingCommonConstant.FUNC_MODEL_CODE);
            if (XiuXingCommonConstant.REN_WU.equals(funcModelCode)) {
                int renWuCount = renWuService.getRenWuCount();
                request.put(XiuXingCommonConstant.REN_WU_CODE, renWuCount + 1);
            }
        }
        return true;
    }
}
