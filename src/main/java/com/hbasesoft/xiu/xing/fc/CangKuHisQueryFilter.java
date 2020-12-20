package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CangKuEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CangKuService;
import com.hbasesoft.xiu.xing.util.GlobalConstants;
import com.hbasesoft.xiu.xing.util.PagerListVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuHisQueryFilter")
public class CangKuHisQueryFilter implements ServiceFilter {

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private CangKuService cangKuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction())) {
            Map<String, Object> cangKuHisMap = flowBean.getRequest();
            if (cangKuHisMap.containsKey(Param.PAGE_INDEX) && cangKuHisMap.containsKey(Param.PAGE_SIZE)) {
                PagerListVo<Map<String, Object>> cangKuHisResponse = (PagerListVo<Map<String, Object>>) flowBean.getResponse();
                if (cangKuHisResponse != null) {
                    List<Map<String, Object>> cangKuHisList = cangKuHisResponse.getDatas();
                    if (CollectionUtils.isNotEmpty(cangKuHisList)) {
                        process(cangKuHisList);
                    }
                }
            }
            else {
                List<Map<String, Object>> cangKuHisList = (List<Map<String, Object>>) flowBean.getResponse();
                if (CollectionUtils.isNotEmpty(cangKuHisList)) {
                    process(cangKuHisList);
                }
            }
        }
    }

    /**
     * Description: 处理翻转信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param cangKuHisList
     * @return <br>
     */
    private void process(List<Map<String, Object>> cangKuHisList) {
        // 处理翻转
        for (Map<String, Object> cangKuHis : cangKuHisList) {
            String cangKuId = (String) cangKuHis.get(XiuXingCommonConstant.CANG_KU_ID);
            CangKuEntity cangKuEntity = cangKuService.getCangKuByCangKuId(cangKuId);
            if (cangKuEntity != null) {
                JSONObject cangKuHisJson = new JSONObject(cangKuHis);
                CangKuEntity cangKuHisEntity =  JSON.toJavaObject(cangKuHisJson, CangKuEntity.class);
                if (Objects.equals(cangKuHisEntity.getCongShuXing(), cangKuEntity.getCongShuXing()) &&
                        Objects.equals(cangKuHisEntity.getCongState(), cangKuEntity.getCongState()) &&
                        Objects.equals(cangKuHisEntity.getCongShuLiang(), cangKuEntity.getCongShuLiang()) &&
                        Objects.equals(cangKuHisEntity.getDanWei(), cangKuEntity.getDanWei()) &&
                        Objects.equals(cangKuHisEntity.getCongHisId(), cangKuEntity.getCongHisId()) &&
                        Objects.equals(cangKuHisEntity.getCongId(), cangKuEntity.getCongId()) &&
                        Objects.equals(cangKuHisEntity.getCongJingJieId(), cangKuEntity.getCongJingJieId()) &&
                        Objects.equals(cangKuHisEntity.getCongPinJiId(), cangKuEntity.getCongPinJiId()) &&
                        Objects.equals(cangKuHisEntity.getCongXiuXing(), cangKuEntity.getCongXiuXing()) &&
                        Objects.equals(cangKuHisEntity.getShuHisId(), cangKuEntity.getShuHisId()) &&
                        Objects.equals(cangKuHisEntity.getShuId(), cangKuEntity.getShuId()) &&
                        Objects.equals(cangKuHisEntity.getXiaoShuoId(), cangKuEntity.getXiaoShuoId()) &&
                        Objects.equals(cangKuHisEntity.getBeiZhu(), cangKuEntity.getBeiZhu())) {
                    cangKuHis.put(XiuXingCommonConstant.FAN_ZHUAN_FLAG, GlobalConstants.YES);
                }
            }
        }
    }
}
