package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CongEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.CongService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <Description> 属新增编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ShuAddUpdateFilter")
public class ShuAddUpdateFilter implements ServiceFilter {

    @Resource
    private ShuHisService shuHisService;

    @Resource
    private CongHisService congHisService;

    @Resource
    private CongService congService;

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> shuReqMap = flowBean.getRequest();
        JSONObject shuJson = new JSONObject(shuReqMap);
        ShuHisEntity shuHisEntity =  JSON.toJavaObject(shuJson, ShuHisEntity.class);
        shuHisEntity.setId(null);
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            shuHisEntity.setShuId((String) flowBean.getResponse());
        } else {
            shuHisEntity.setShuId((String) shuReqMap.get(XiuXingCommonConstant.ID));
        }
        shuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        String shuHisId = shuHisService.saveOrUpdateShuHis(shuHisEntity);

        // 如果属信息中存在章节ID，则将属信息与章节ID信息保存到zhang_jie_cong_shu
        String zhangJieId = (String) shuReqMap.get("zhangJieId");

        // 如果属类型包含从，则在从中也添加对应的记录
        String shuType = (String) shuReqMap.get(XiuXingCommonConstant.SHU_TYPE);
        if (StringUtils.isNotEmpty(shuType) && shuType.contains(XiuXingCommonConstant.CONG_SHU_CONG)) {
            CongHisEntity congHisEntity = new CongHisEntity();
            congHisEntity.setCongName(shuHisEntity.getShuName());
            congHisEntity.setCongFenLei(shuHisEntity.getShuFenLei());
            congHisEntity.setCongMiaoShu(shuHisEntity.getShuMiaoShu());
            congHisEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
            congHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            List<CongHisEntity> congHisEntityList = congHisService.getCongHisList(congHisEntity);
            if (CollectionUtils.isEmpty(congHisEntityList)) {
                CongEntity congEntity = new CongEntity();
                congEntity.setCongName(congHisEntity.getCongName());
                congEntity.setCongFenLei(congHisEntity.getCongFenLei());
                congEntity.setCongMiaoShu(congHisEntity.getCongMiaoShu());
                congEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                congEntity.setUpdateTime(congHisEntity.getUpdateTime());
                int congCount =  congService.getCongCount();
                congEntity.setCongCode(String.valueOf(++congCount));
                String congId = congService.saveCong(congEntity);
                congHisEntity.setCongId(congId);
                congHisEntity.setCongCode(congEntity.getCongCode());
                String congHisId = congHisService.saveCongHis(congHisEntity);
                congHisEntity.setId(congHisId);
                // 属管理中，新增或编辑同步到从管理中时，存在章节ID
                if (StringUtils.isNotEmpty(zhangJieId)) {
                    // 删除zhang_jie_cong_shu表中的对应章节的空数据
                    int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
                    LoggerUtil.info("[属]删除章节从空数据：{0}", emptyCount);
                    // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
                    // 如果存在，则不作任何处理
                    // 如果不存在，则添加到zhang_jie_cong_shu表中
                    ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                    zhangJieCongShuEntity.setType("从");
                    zhangJieCongShuEntity.setCongShuHisId(congHisId);
                    zhangJieCongShuEntity.setCongShuId(congHisEntity.getCongId());
                    zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                    zhangJieCongShuEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                    zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
                }
            }
        }

        if (StringUtils.isNotEmpty(zhangJieId)) {
            // 删除zhang_jie_cong_shu表中的对应章节的空数据
            int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
            LoggerUtil.info("[属]删除章节属空数据：{0}", emptyCount);
            // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
            // 如果存在，则不作任何处理
            // 如果不存在，则添加到zhang_jie_cong_shu表中
            ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
            zhangJieCongShuEntity.setType("属");
            zhangJieCongShuEntity.setCongShuHisId(shuHisId);
            zhangJieCongShuEntity.setCongShuId(shuHisEntity.getShuId());
            zhangJieCongShuEntity.setZhangJieId(zhangJieId);
            zhangJieCongShuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
        }
    }
}
