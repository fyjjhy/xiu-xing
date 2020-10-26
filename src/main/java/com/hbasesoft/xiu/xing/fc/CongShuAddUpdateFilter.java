package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CongShuHisEntity;
import com.hbasesoft.xiu.xing.service.CongShuHisService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 从属新增编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Deprecated
@Component("CongShuAddUpdateFilter")
public class CongShuAddUpdateFilter implements ServiceFilter {

    @Resource
    private CongShuHisService congShuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> congShuReqMap = flowBean.getRequest();
        JSONObject cangKuJson = new JSONObject(congShuReqMap);
        CongShuHisEntity congShuHisEntity =  JSON.toJavaObject(cangKuJson, CongShuHisEntity.class);
        congShuHisEntity.setId(null);
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            congShuHisEntity.setCongShuId((String) flowBean.getResponse());
        } else {
            congShuHisEntity.setCongShuId((String) congShuReqMap.get(XiuXingCommonConstant.ID));
        }
        congShuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        congShuHisService.saveOrUpdateCongShuHis(congShuHisEntity);
    }
}
