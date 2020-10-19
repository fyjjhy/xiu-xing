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
 * <Description> 仓库属历史查询过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月07日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuShuHisQueryFilter")
public class CangKuShuHisQueryFilter implements ServiceFilter {

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuShuHisMap = flowBean.getRequest();
        if (cangKuShuHisMap.containsKey("shuIds")) {
            String shuIds = (String) cangKuShuHisMap.get("shuIds");
            LoggerUtil.info("shuIds: {0}", shuIds);
            if (StringUtils.isNotEmpty(shuIds)) {
                // SQL语句中，IN中使用集合而不是数组
                cangKuShuHisMap.put("shuIds", Arrays.asList(shuIds.split(GlobalConstants.SPLITOR)));
            }
        }
        return true;
    }
}
