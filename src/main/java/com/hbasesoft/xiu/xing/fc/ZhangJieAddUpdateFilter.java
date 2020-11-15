package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.CongShuInfo;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
        LoggerUtil.info("[章节信息] 新增或更新入参：{0}", zhangJieCongShuReqMap);
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
                for (Map<String, Object> congHisInfoMap : congHisMapList) {
                    JSONObject congHisInfoJson = new JSONObject(congHisInfoMap);
                    CongShuInfo congShuInfo =  JSON.toJavaObject(congHisInfoJson, CongShuInfo.class);
                    if (CollectionUtils.isNotEmpty(congShuInfo.getAddrIds())) {
                        for (String addrId : congShuInfo.getAddrIds()) {
                            ZhangJieCongShuEntity zhangJieCongShuEntity = getZhangJieCongEntity(zhangJieId, congShuInfo);
                            zhangJieCongShuEntity.setAddrId(addrId);
                            zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                        }
                    }
                    else {
                        ZhangJieCongShuEntity zhangJieCongShuEntity = getZhangJieCongEntity(zhangJieId, congShuInfo);
                        zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                    }
                }
            }
        }

        if (zhangJieCongShuReqMap.containsKey("shuInfos")) {
            List<Map<String, Object>> shuHisMapList = (List<Map<String, Object>>) zhangJieCongShuReqMap.get("shuInfos");
            if (CollectionUtils.isNotEmpty(shuHisMapList)) {
                for (Map<String, Object> shuHisInfoMap : shuHisMapList) {
                    JSONObject shuHisInfoJson = new JSONObject(shuHisInfoMap);
                    CongShuInfo congShuInfo =  JSON.toJavaObject(shuHisInfoJson, CongShuInfo.class);
                    if (CollectionUtils.isNotEmpty(congShuInfo.getAddrIds())) {
                        for (String addrId : congShuInfo.getAddrIds()) {
                            ZhangJieCongShuEntity zhangJieCongShuEntity = getZhangJieShuEntity(zhangJieId, congShuInfo);
                            zhangJieCongShuEntity.setAddrId(addrId);
                            zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                        }
                    }
                    else {
                        ZhangJieCongShuEntity zhangJieCongShuEntity = getZhangJieShuEntity(zhangJieId, congShuInfo);
                        zhangJieCongShuEntityList.add(zhangJieCongShuEntity);
                    }
                }
            }
        }
        // 删除原有的数据
        int zhangJieCongShuCount = zhangJieCongShuService.delZhangJieCongShuByZhangJieId(zhangJieId);
        LoggerUtil.info("[章节信息]先删除再新增：{0}", zhangJieCongShuCount);
        zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntityList);
    }

    /**
     * Description: 根据属信息构建章节属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @param congShuInfo
     * @return <br>
     */
    private ZhangJieCongShuEntity getZhangJieShuEntity(String zhangJieId, CongShuInfo congShuInfo) {
        ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
        zhangJieCongShuEntity.setXiaoShuoId(congShuInfo.getXiaoShuoId());
        zhangJieCongShuEntity.setCongShuHisId(congShuInfo.getCongShuHisId());
        zhangJieCongShuEntity.setCongShuId(congShuInfo.getCongShuId());
        zhangJieCongShuEntity.setType("属");
        zhangJieCongShuEntity.setZhangJieId(zhangJieId);
        zhangJieCongShuEntity.setId(CommonUtil.getTransactionID());
        return zhangJieCongShuEntity;
    }

    /**
     * Description: 根据从信息构建章节从信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @param congShuInfo
     * @return <br>
     */
    private ZhangJieCongShuEntity getZhangJieCongEntity(String zhangJieId, CongShuInfo congShuInfo) {
        ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
        zhangJieCongShuEntity.setXiaoShuoId(congShuInfo.getXiaoShuoId());
        if (StringUtils.isNotEmpty(congShuInfo.getCangKuHisId())) {
            zhangJieCongShuEntity.setCongShuHisId(congShuInfo.getCangKuHisId());
            zhangJieCongShuEntity.setType("仓从");
        }
        else {
            zhangJieCongShuEntity.setCongShuHisId(congShuInfo.getCongShuHisId());
            zhangJieCongShuEntity.setCongShuId(congShuInfo.getCongShuId());
            zhangJieCongShuEntity.setType("从");
        }
        zhangJieCongShuEntity.setZhangJieId(zhangJieId);
        zhangJieCongShuEntity.setId(CommonUtil.getTransactionID());
        return zhangJieCongShuEntity;
    }
}
