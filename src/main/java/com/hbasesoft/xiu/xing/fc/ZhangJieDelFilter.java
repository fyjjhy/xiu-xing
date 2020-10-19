package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 章节删除过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ZhangJieDelFilter")
public class ZhangJieDelFilter implements ServiceFilter {

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> zhangJieCongShuReqMap = flowBean.getRequest();
        LoggerUtil.info("zhangJieCongShuReqMap:{0}", zhangJieCongShuReqMap);
        String zhangJieId = (String) zhangJieCongShuReqMap.get(XiuXingCommonConstant.RES_ID);
        int delZhangJieCongShuCount = zhangJieCongShuService.delZhangJieCongShuByZhangJieId(zhangJieId);
        LoggerUtil.info("[删除] 删除章节从属数量：{0}", delZhangJieCongShuCount);
        return true;
    }
}
