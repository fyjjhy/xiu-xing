package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.CongEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.entity.ShuEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.CongService;
import com.hbasesoft.xiu.xing.service.CongShuHisService;
import com.hbasesoft.xiu.xing.service.CongShuService;
import com.hbasesoft.xiu.xing.service.HenJiService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.PinJiService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import com.hbasesoft.xiu.xing.service.ShuService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

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
@Component("CangKuAddUpdateFilter")
public class CangKuAddUpdateFilter implements ServiceFilter {

    @Resource
    private JingJieService jingJieService;

    @Resource
    private PinJiService pinJiService;

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private HenJiService henJiService;

    @Resource
    private CongShuService congShuService;

    @Resource
    private CongShuHisService congShuHisService;

    @Resource
    private CongService congService;

    @Resource
    private CongHisService congHisService;

    @Resource
    private ShuService shuService;

    @Resource
    private ShuHisService shuHisService;

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuRequest = flowBean.getRequest();
        if (MapUtils.isNotEmpty(cangKuRequest)) {
            String congId = (String) cangKuRequest.get("congId");
            String congFenLei = (String) cangKuRequest.get("congFenLei");
            String congName = (String) cangKuRequest.get("congName");
            String congMiaoShu = (String) cangKuRequest.get("congMiaoShu");
            String xiaoShuoId = (String) cangKuRequest.get("xiaoShuoId");
            CongHisEntity congHisEntity = new CongHisEntity();
            congHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            congHisEntity.setXiaoShuoId(xiaoShuoId);
            congHisEntity.setCongMiaoShu(congMiaoShu);
            congHisEntity.setCongFenLei(congFenLei);
            congHisEntity.setCongName(congName);
            if (StringUtils.isNotEmpty(congId)) {
                CongEntity congEntity = congService.getCongById(congId);
                Assert.notNull(congEntity, XiuXingErrorCodeDef.CONG_INFO_IS_EMPTY);
                congHisEntity.setCongId(congId);
                congHisEntity.setCongCode(congEntity.getCongCode());
                String congHisId = congHisService.saveOrUpdateCongHis(congHisEntity);
                congHisEntity.setId(congHisId);
                cangKuRequest.put("congHisId", congHisId);
            }
            else {
                CongEntity congEntity = new CongEntity();
                int congCount = congService.getCongCount();
                congEntity.setCongCode(String.valueOf(++congCount));
                congEntity.setCongName(congName);
                congEntity.setCongFenLei(congFenLei);
                congEntity.setCongMiaoShu(congMiaoShu);
                congEntity.setUpdateTime(congHisEntity.getUpdateTime());
                congEntity.setXiaoShuoId(xiaoShuoId);
                String congInfoId = congService.saveCong(congEntity);
                congHisEntity.setCongId(congInfoId);
                congHisEntity.setCongCode(congEntity.getCongCode());
                congHisEntity.setUpdateTime(congEntity.getUpdateTime());
                String congHisId = congHisService.saveOrUpdateCongHis(congHisEntity);
                congHisEntity.setId(congHisId);
                cangKuRequest.put("congId", congInfoId);
                cangKuRequest.put("congHisId", congHisId);
            }

            String shuId = (String) cangKuRequest.get("shuId");
            String shuFenLei = (String) cangKuRequest.get("shuFenLei");
            String shuName = (String) cangKuRequest.get("shuName");
            String shuMiaoShu = (String) cangKuRequest.get("shuMiaoShu");
            String addrId = (String) cangKuRequest.get("addrId");
            String shuJingJieId = (String) cangKuRequest.get("shuJingJieId");
            String shuPinJiId = (String) cangKuRequest.get("shuPinJiId");
            ShuHisEntity shuHisEntity = new ShuHisEntity();
            shuHisEntity.setShuId(shuId);
            shuHisEntity.setShuFenLei(shuFenLei);
            shuHisEntity.setShuName(shuName);
            shuHisEntity.setShuMiaoShu(shuMiaoShu);
            shuHisEntity.setXiaoShuoId(xiaoShuoId);
            shuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            shuHisEntity.setAddrId(addrId);
            shuHisEntity.setShuJingJieId(shuJingJieId);
            shuHisEntity.setShuPinJiId(shuPinJiId);
            if (StringUtils.isNotEmpty(shuId)) {
                ShuEntity shuEntity = shuService.getShuById(shuId);
                Assert.notNull(shuEntity, XiuXingErrorCodeDef.SHU_INFO_IS_EMPTY);
                shuHisEntity.setShuCode(shuEntity.getShuCode());
                String shuHisId = shuHisService.saveOrUpdateShuHis(shuHisEntity);
                shuHisEntity.setId(shuHisId);
                cangKuRequest.put("shuHisId", shuHisId);
            } else {
                ShuEntity shuEntity = new ShuEntity();
                int shuCount = shuService.getShuCount();
                shuEntity.setShuCode(String.valueOf(++shuCount));
                shuEntity.setShuName(shuName);
                shuEntity.setShuFenLei(shuFenLei);
                shuEntity.setShuMiaoShu(shuMiaoShu);
                shuEntity.setUpdateTime(DateUtil.getCurrentDate());
                shuEntity.setXiaoShuoId(xiaoShuoId);
                shuEntity.setAddrId(addrId);
                shuEntity.setShuJingJieId(shuJingJieId);
                shuEntity.setShuPinJiId(shuPinJiId);
                String shuInfoId = shuService.saveShu(shuEntity);
                cangKuRequest.put("shuId", shuInfoId);
                shuHisEntity.setShuId(shuInfoId);
                shuHisEntity.setShuCode(shuEntity.getShuCode());
                shuHisEntity.setUpdateTime(shuEntity.getUpdateTime());
                String shuHisId = shuHisService.saveOrUpdateShuHis(shuHisEntity);
                shuHisEntity.setId(shuHisId);
                cangKuRequest.put("shuHisId", shuHisId);
            }

            String xiuXingShiJian = (String) cangKuRequest.get("xiuXingShiJian");
            String beiZhu = (String) cangKuRequest.get("beiZhu");
            HenJiEntity henJiEntity = new HenJiEntity();
            henJiEntity.setXiuXingShiJian(StringUtils.isNotEmpty(xiuXingShiJian) ? xiuXingShiJian : null);
            henJiEntity.setBeiZhu(StringUtils.isNotEmpty(beiZhu) ? beiZhu : null);
            henJiEntity.setXiaoShuoId(xiaoShuoId);
            if (!(StringUtils.isEmpty(beiZhu) && StringUtils.isEmpty(xiuXingShiJian))) {
                String henJiId = henJiService.saveHenJi(henJiEntity);
                cangKuRequest.put("henJiId", henJiId);
            }
            else {
                cangKuRequest.put("henJiId", null);
            }

            // 如果仓库信息中存在章节ID，则将从信息、属信息与章节ID信息保存到zhang_jie_cong_shu
            String zhangJieId = (String) cangKuRequest.get("zhangJieId");
            if (StringUtils.isNotEmpty(zhangJieId)) {
                // 删除zhang_jie_cong_shu表中的对应章节的空数据
                int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
                LoggerUtil.info("[仓库]删除章节从空数据：{0}", emptyCount);
                // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
                // 如果存在，则不作任何处理
                // 如果不存在，则添加到zhang_jie_cong_shu表中
                ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                zhangJieCongShuEntity.setType("从");
                zhangJieCongShuEntity.setCongShuHisId(congHisEntity.getId());
                zhangJieCongShuEntity.setCongShuId(congHisEntity.getCongId());
                zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                zhangJieCongShuEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
            }

            // 如果仓库信息中存在章节ID，则将从信息、属信息与章节ID信息保存到zhang_jie_cong_shu
            if (StringUtils.isNotEmpty(zhangJieId)) {
                // 删除zhang_jie_cong_shu表中的对应章节的空数据
                int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
                LoggerUtil.info("[仓库]删除章节属空数据：{0}", emptyCount);
                // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
                // 如果存在，则不作任何处理
                // 如果不存在，则添加到zhang_jie_cong_shu表中
                ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
                zhangJieCongShuEntity.setType("属");
                zhangJieCongShuEntity.setCongShuHisId(shuHisEntity.getId());
                zhangJieCongShuEntity.setCongShuId(shuHisEntity.getShuId());
                zhangJieCongShuEntity.setZhangJieId(zhangJieId);
                zhangJieCongShuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
                zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
            }

//            String congJingJieId = (String) cangKuRequest.get("congJingJieId");
//            String congPinJiId = (String) cangKuRequest.get("congPinJiId");
//            if (StringUtils.isNotEmpty(congJingJieId)) {
//                JingJieEntity jingJieEntity = jingJieService.getJingJieById(congJingJieId);
//                cangKuRequest.put("congJingJieName", jingJieEntity.getJingJieName());
//            }
//            else {
//                cangKuRequest.put("congJingJieName", null);
//            }
//
//            if (StringUtils.isNotEmpty(congPinJiId)) {
//                PinJiEntity pinJiEntity = pinJiService.getPinJiById(congPinJiId);
//                cangKuRequest.put("congPinJiName", pinJiEntity.getPinJiName());
//            }
//            else {
//                cangKuRequest.put("congPinJiName", null);
//            }
//
//            if (StringUtils.isNotEmpty(shuJingJieId)) {
//                JingJieEntity jingJieEntity = jingJieService.getJingJieById(shuJingJieId);
//                cangKuRequest.put("shuJingJieName", jingJieEntity.getJingJieName());
//            }
//            else {
//                cangKuRequest.put("shuJingJieName", null);
//            }
//
//            if (StringUtils.isNotEmpty(shuPinJiId)) {
//                PinJiEntity pinJiEntity = pinJiService.getPinJiById(shuPinJiId);
//                cangKuRequest.put("shuPinJiName", pinJiEntity.getPinJiName());
//            }
//            else {
//                cangKuRequest.put("shuPinJiName", null);
//            }
        }
        return true;
    }

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
