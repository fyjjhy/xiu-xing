package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.LingWuHisEntity;
import com.hbasesoft.xiu.xing.service.LingWuHisService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 灵物新增过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("LingWuAddUpdateFilter")
public class LingWuAddUpdateFilter implements ServiceFilter {

    @Resource
    private LingWuHisService lingWuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> lingWuReqMap = flowBean.getRequest();
        JSONObject cangKuJson = new JSONObject(lingWuReqMap);
        LingWuHisEntity lingWuHisEntity =  JSON.toJavaObject(cangKuJson, LingWuHisEntity.class);
        lingWuHisEntity.setId(null);
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            lingWuHisEntity.setLingWuId((String) flowBean.getResponse());
        } else {
            lingWuHisEntity.setLingWuId((String) lingWuReqMap.get(XiuXingCommonConstant.ID));
        }
        lingWuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        lingWuHisService.saveOrUpdateLingWuHis(lingWuHisEntity);
    }
}
