package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <Description> 章节新增或编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ZhangJieAddUpdateFilter")
public class ZhangJieAddUpdateFilter implements ServiceFilter {

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> zhangJieCongShuReqMap = flowBean.getRequest();
        String zhangJieId = null;
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            zhangJieId = (String) flowBean.getResponse();
        } else {
            zhangJieId = (String) zhangJieCongShuReqMap.get(XiuXingCommonConstant.ID);
        }
        List<ZhangJieCongShuEntity> zhangJieCongShuEntityList = new ArrayList<>();
        if (zhangJieCongShuReqMap.containsKey("congInfos")) {
            List<Map<String, Object>> congHisMapList = (List<Map<String, Object>>) zhangJieCongShuReqMap.get("congInfos");
            if (CollectionUtils.isNotEmpty(congHisMapList)) {
                for (Map<String, Object> congHisMap : congHisMapList) {
                    JSONObject congHisJson = new JSONObject(congHisMap);
                    CongHisEntity congHisEntity =  JSON.toJavaObject(congHisJson, CongHisEntity.class);
                    ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                    zhangJieCongShuEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                    zhangJieCongShuEntity.setCongShuHisId(congHisEntity.getId());
                    zhangJieCongShuEntity.setCongShuId(congHisEntity.getCongId());
                    zhangJieCongShuEntity.setType("从");
                    zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                    zhangJieCongShuEntity.setId(CommonUtil.getTransactionID());
                    zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                }
            }
        }

        if (zhangJieCongShuReqMap.containsKey("shuInfos")) {
            List<Map<String, Object>> shuHisMapList = (List<Map<String, Object>>) zhangJieCongShuReqMap.get("shuInfos");
            if (CollectionUtils.isNotEmpty(shuHisMapList)) {
                for (Map<String, Object> shuHisMap : shuHisMapList) {
                    JSONObject shuHisJson = new JSONObject(shuHisMap);
                    ShuHisEntity shuHisEntity =  JSON.toJavaObject(shuHisJson, ShuHisEntity.class);
                    ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                    zhangJieCongShuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
                    zhangJieCongShuEntity.setCongShuHisId(shuHisEntity.getId());
                    zhangJieCongShuEntity.setCongShuId(shuHisEntity.getShuId());
                    zhangJieCongShuEntity.setType("属");
                    zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                    zhangJieCongShuEntity.setId(CommonUtil.getTransactionID());
                    zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                }
            }
        }
        // 删除原有的数据
        int zhangJieCongShuCount = zhangJieCongShuService.delZhangJieCongShuByZhangJieId(zhangJieId);
        LoggerUtil.info("delZhangJieCongShuCount：{0}", zhangJieCongShuCount);
        if (CollectionUtils.isEmpty(zhangJieCongShuEntityList)) {
            ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
            zhangJieCongShuEntity.setXiaoShuoId(null);
            zhangJieCongShuEntity.setCongShuHisId(null);
            zhangJieCongShuEntity.setCongShuId(null);
            zhangJieCongShuEntity.setType(null);
            zhangJieCongShuEntity.setZhangJieId(zhangJieId);
            zhangJieCongShuEntity.setId(CommonUtil.getTransactionID());
            zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
        }
        zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntityList);
    }
}
