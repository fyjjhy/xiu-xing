package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.CongHis;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.bean.ShuHis;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <Description> 章节Get过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ZhangJieGetFilter")
public class ZhangJieGetFilter implements ServiceFilter {

    @Resource
    private CongHisService congHisService;

    @Resource
    private ShuHisService shuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        // 获取单条数据
        Map<String, Object> zhangJieMap = (Map<String, Object>) flowBean.getResponse();
        if (MapUtils.isNotEmpty(zhangJieMap)) {
            String congHisIds = (String) zhangJieMap.get("congHisIds");
            if (StringUtils.isNotEmpty(congHisIds)) {
                List<CongHis> congHisList = congHisService.getCongHisListById(congHisIds);
                if (CollectionUtils.isNotEmpty(congHisList)) {
                    zhangJieMap.put("congInfo", congHisList);
                }
            }

            String shuHisIds = (String) zhangJieMap.get("shuHisIds");
            if (StringUtils.isNotEmpty(shuHisIds)) {
                List<ShuHis> shuHisList = shuHisService.getShuHisListById(shuHisIds);
                if (CollectionUtils.isNotEmpty(shuHisList)) {
                    zhangJieMap.put("shuInfo", shuHisList);
                }
            }
        }
    }
}
