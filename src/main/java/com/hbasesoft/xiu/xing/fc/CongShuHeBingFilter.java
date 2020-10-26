package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CangKuService;
import com.hbasesoft.xiu.xing.service.CongShuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 从属合并过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Deprecated
@Component("CongShuHeBingFilter")
public class CongShuHeBingFilter implements ServiceFilter {

    @Resource
    private CongShuService congShuService;

    @Resource
    private CangKuService cangKuService;

    @Resource
    private CangKuHisService cangKuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> congShuReqMap = flowBean.getRequest();
        if (XiuXingCommonConstant.HE_BING.equals(action)) {
            String originCongShuId = (String) congShuReqMap.get("origin");
            String targetCongShuId = (String) congShuReqMap.get("target");
            // 更新仓库信息
            int cangKuCount = cangKuService.updateCangKuByCongShuId(originCongShuId, targetCongShuId);
            LoggerUtil.info("更新仓库信息：{0}", cangKuCount);
            // 更新仓库历史信息
            int cangKuHisCount = cangKuHisService.updateCangKuHisByCongShuId(originCongShuId, targetCongShuId);
            LoggerUtil.info("更新仓库历史信息：{0}", cangKuHisCount);
            // 删除origin从属信息
            congShuService.delCongShuById(originCongShuId);
        }
    }
}
