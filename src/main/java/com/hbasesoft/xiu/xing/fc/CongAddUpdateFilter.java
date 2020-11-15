package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.ShuEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import com.hbasesoft.xiu.xing.service.ShuService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <Description> 从新增编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CongAddUpdateFilter")
public class CongAddUpdateFilter implements ServiceFilter {

    @Resource
    private CongHisService congHisService;

    @Resource
    private ShuHisService shuHisService;

    @Resource
    private ShuService shuService;

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action = flowBean.getAction();
        Map<String, Object> congReqMap = flowBean.getRequest();
        JSONObject congJson = new JSONObject(congReqMap);
        CongHisEntity congHisEntity = JSON.toJavaObject(congJson, CongHisEntity.class);
        congHisEntity.setId(null);
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            congHisEntity.setCongId((String) flowBean.getResponse());
        } else {
            congHisEntity.setCongId((String) congReqMap.get(XiuXingCommonConstant.ID));
        }
        congHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        String congHisId = congHisService.saveOrUpdateCongHis(congHisEntity);

        // 如果从信息中存在章节ID，则将从信息与章节ID信息保存到zhang_jie_cong_shu
        String zhangJieId = (String) congReqMap.get("zhangJieId");
        String addrId = (String) congReqMap.get("addrId");

        // 如果从类型包含属，则在属中也添加对应的记录
        String congType = (String) congReqMap.get(XiuXingCommonConstant.CONG_TYPE);
        if (StringUtils.isNotEmpty(congType) && congType.contains(XiuXingCommonConstant.CONG_SHU_SHU)) {
            ShuHisEntity shuHisEntity = new ShuHisEntity();
            shuHisEntity.setShuName(congHisEntity.getCongName());
            shuHisEntity.setShuFenLei(congHisEntity.getCongFenLei());
            shuHisEntity.setShuMiaoShu(congHisEntity.getCongMiaoShu());
            shuHisEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
            shuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            List<ShuHisEntity> shuHisEntityList = shuHisService.getShuHisList(shuHisEntity);
            if (CollectionUtils.isEmpty(shuHisEntityList)) {
                ShuEntity shuEntity = new ShuEntity();
                shuEntity.setShuName(shuHisEntity.getShuName());
                shuEntity.setShuFenLei(shuHisEntity.getShuFenLei());
                shuEntity.setShuMiaoShu(shuHisEntity.getShuMiaoShu());
                shuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
                shuEntity.setUpdateTime(shuHisEntity.getUpdateTime());
                int shuCount = shuService.getShuCount();
                shuEntity.setShuCode(String.valueOf(++shuCount));
                String shuId = shuService.saveShu(shuEntity);
                shuHisEntity.setShuId(shuId);
                shuHisEntity.setShuCode(shuEntity.getShuCode());
                String shuHisId = shuHisService.saveShuHis(shuHisEntity);
                shuHisEntity.setId(shuHisId);
                // 从管理中，新增或编辑同步到属管理中时，存在章节ID
                if (StringUtils.isNotEmpty(zhangJieId)) {
                    // 删除zhang_jie_cong_shu表中的对应章节的空数据
                    // int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
                    // LoggerUtil.info("[从]删除章节属空数据：{0}", emptyCount);
                    // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
                    // 如果存在，则不作任何处理
                    // 如果不存在，则添加到zhang_jie_cong_shu表中
                    ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                    zhangJieCongShuEntity.setType("属");
                    zhangJieCongShuEntity.setCongShuHisId(shuHisEntity.getId());
                    zhangJieCongShuEntity.setCongShuId(shuHisEntity.getShuId());
                    // zhangJieCongShuEntity.setCongShuFenLei(shuHisEntity.getShuFenLei());
                    // zhangJieCongShuEntity.setCongShuMiaoShu(shuHisEntity.getShuMiaoShu());
                    // zhangJieCongShuEntity.setCongShuName(shuHisEntity.getShuName());
                    zhangJieCongShuEntity.setAddrId(addrId);
                    zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                    zhangJieCongShuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
                    zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
                }
            }
        }

        if (StringUtils.isNotEmpty(zhangJieId)) {
            // 删除zhang_jie_cong_shu表中的对应章节的空数据
            // int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
            // LoggerUtil.info("[从]删除章节从空数据：{0}", emptyCount);
            // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
            // 如果存在，则不作任何处理
            // 如果不存在，则添加到zhang_jie_cong_shu表中
            ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
            zhangJieCongShuEntity.setType("从");
            zhangJieCongShuEntity.setCongShuHisId(congHisId);
            zhangJieCongShuEntity.setCongShuId(congHisEntity.getCongId());
            // zhangJieCongShuEntity.setCongShuFenLei(congHisEntity.getCong1FenLei());
            // zhangJieCongShuEntity.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
            // zhangJieCongShuEntity.setCongShuName(congHisEntity.getCongName());
            zhangJieCongShuEntity.setAddrId(addrId);
            zhangJieCongShuEntity.setZhangJieId(zhangJieId);
            zhangJieCongShuEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
        }
    }
}
