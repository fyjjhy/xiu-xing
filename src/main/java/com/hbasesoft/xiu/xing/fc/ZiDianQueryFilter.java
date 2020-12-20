package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.util.GlobalConstants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <Description> 字典查询过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月07日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ZiDianQueryFilter")
public class ZiDianQueryFilter implements ServiceFilter {

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> ziDianMap = flowBean.getRequest();
        if (ziDianMap.containsKey("ziName")) {
            String ziName = (String) ziDianMap.get("ziName");
            List<String> ziNameList = new ArrayList<>(Arrays.asList(ziName.split(GlobalConstants.BLANK)));
            ziDianMap.put("ziName", ziNameList);
        }
        return true;
    }
}
