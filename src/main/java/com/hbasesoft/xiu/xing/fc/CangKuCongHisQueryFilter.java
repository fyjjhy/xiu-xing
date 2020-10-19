package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.util.GlobalConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

/**
 * <Description> 仓库从历史查询过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月07日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuCongHisQueryFilter")
public class CangKuCongHisQueryFilter implements ServiceFilter {

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuCongHisMap = flowBean.getRequest();
        if (cangKuCongHisMap.containsKey("congIds")) {
            String congIds = (String) cangKuCongHisMap.get("congIds");
            LoggerUtil.info("congIds: {0}", congIds);
            if (StringUtils.isNotEmpty(congIds)) {
                // SQL语句中，IN中使用集合而不是数组
                cangKuCongHisMap.put("congIds", Arrays.asList(congIds.split(GlobalConstants.SPLITOR)));
            }
        }
        return true;
    }
}
