package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 仓库新增编辑后置拦截器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuAddUpdateAfterFilter")
public class CangKuAddUpdateAfterFilter implements ServiceFilter {

    @Resource
    private CangKuHisService cangKuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        Map<String, Object> cangKuReqMap = flowBean.getRequest();
        JSONObject cangKuJson = new JSONObject(cangKuReqMap);
        CangKuHisEntity cangKuHisEntity =  JSON.toJavaObject(cangKuJson, CangKuHisEntity.class);
        cangKuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        if (ServiceFlowBean.ACTION_ADD.equals(flowBean.getAction())) {
            String cangKuId = (String) flowBean.getResponse();
            cangKuHisEntity.setCangKuId(cangKuId);
        } else if (ServiceFlowBean.ACTION_UPDATE.equals(flowBean.getAction())) {
            cangKuHisEntity.setCangKuId(cangKuHisEntity.getId());
            cangKuHisEntity.setId(null);
        }
        cangKuHisService.saveOrUpdateCangKuHis(cangKuHisEntity);
    }
}
