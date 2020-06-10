package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <Description> 人物查询过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月07日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("RenWuQueryFilter")
public class RenWuQueryFilter implements ServiceFilter {

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> renWuMap = flowBean.getRequest();
        List<String> renWuFenLeiList = new ArrayList<>();
        for (String key : renWuMap.keySet()) {
            if (key.indexOf(XiuXingCommonConstant.REN_WU_FEN_LEI) != -1) {
                String value = (String) renWuMap.get(key);
                renWuFenLeiList.add(value);
            }
        }

        if (CollectionUtils.isNotEmpty(renWuFenLeiList)) {
            renWuMap.put(XiuXingCommonConstant.REN_WU_FEN_LEI, renWuFenLeiList);
        }
        return true;
    }
}
