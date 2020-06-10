package com.hbasesoft.xiu.xing.service.impl;

import com.alibaba.fastjson.JSON;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowHelper;
import com.hbasesoft.xiu.xing.bean.Serv;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.ProcessEntity;
import com.hbasesoft.xiu.xing.service.ComponentService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@Service
public class ComponentServiceImpl implements ComponentService {

    @Override
    public Object perform(String action, Map<String, Object> data, String resId, Serv entity, ProcessEntity processEntity) {
        if (MapUtils.isEmpty(data)) {
            data = new HashMap<>();
            data.put(XiuXingCommonConstant.RES_ID, resId);
        } else if (StringUtils.isNotEmpty(resId) && data.containsKey(resId)) {
            Assert.equals(resId, data.get(XiuXingCommonConstant.RES_ID), XiuXingErrorCodeDef.RES_ID_NOT_MATCH);
        } else {
            data.put(XiuXingCommonConstant.RES_ID, resId);
        }
        // 获取服务
        Assert.notNull(entity, XiuXingErrorCodeDef.SERVICE_NOT_FOUND);
        ServiceFlowBean flowBean = new ServiceFlowBean();
        BeanUtils.copyProperties(entity, flowBean);
        flowBean.setRequest(data);
        flowBean.setAction(action);
        FlowHelper.flowStart(flowBean, JSON.parseObject(processEntity.getContent()), true);
        return flowBean.getResponse();
    }
}
