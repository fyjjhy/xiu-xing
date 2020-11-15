package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.CongEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.ShuEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.CongService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import com.hbasesoft.xiu.xing.service.ShuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 仓库新增编辑前置过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuAddUpdateBeforeFilter")
public class CangKuAddUpdateBeforeFilter implements ServiceFilter {

    @Resource
    private CongService congService;

    @Resource
    private CongHisService congHisService;

    @Resource
    private ShuService shuService;

    @Resource
    private ShuHisService shuHisService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuRequest = flowBean.getRequest();
        LoggerUtil.info("[仓库-新增/编辑] 入参：{0}", cangKuRequest);
        if (MapUtils.isNotEmpty(cangKuRequest)) {
            String congId = (String) cangKuRequest.get("congId");
            String congFenLei = (String) cangKuRequest.get("congFenLei");
            String congName = (String) cangKuRequest.get("congName");
            String congMiaoShu = (String) cangKuRequest.get("congMiaoShu");
            String xiaoShuoId = (String) cangKuRequest.get("xiaoShuoId");
            CongHisEntity congHisEntity = new CongHisEntity();
            congHisEntity.setCongId(congId);
            congHisEntity.setCongName(congName);
            congHisEntity.setCongFenLei(congFenLei);
            congHisEntity.setCongMiaoShu(congMiaoShu);
            congHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            congHisEntity.setXiaoShuoId(xiaoShuoId);
            if (StringUtils.isNotEmpty(congId)) {
                CongEntity congEntity = congService.getCongById(congId);
                Assert.notNull(congEntity, XiuXingErrorCodeDef.CONG_INFO_IS_EMPTY);
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
            String shuState = (String) cangKuRequest.get("shuState");
            String shuMiaoShu = (String) cangKuRequest.get("shuMiaoShu");
            String shuJingJieId = (String) cangKuRequest.get("shuJingJieId");
            String shuPinJiId = (String) cangKuRequest.get("shuPinJiId");
            String shuXiuXing = (String) cangKuRequest.get("shuXiuXing");
            ShuHisEntity shuHisEntity = new ShuHisEntity();
            shuHisEntity.setShuId(shuId);
            shuHisEntity.setShuFenLei(shuFenLei);
            shuHisEntity.setShuName(shuName);
            shuHisEntity.setShuState(shuState);
            shuHisEntity.setShuMiaoShu(shuMiaoShu);
            shuHisEntity.setXiaoShuoId(xiaoShuoId);
            shuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
//            shuHisEntity.setAddrId(addrId);
            shuHisEntity.setShuJingJieId(shuJingJieId);
            shuHisEntity.setShuPinJiId(shuPinJiId);
            shuHisEntity.setShuXiuXing(shuXiuXing);
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
                shuEntity.setShuState(shuState);
                shuEntity.setShuFenLei(shuFenLei);
                shuEntity.setShuMiaoShu(shuMiaoShu);
                shuEntity.setUpdateTime(DateUtil.getCurrentDate());
                shuEntity.setXiaoShuoId(xiaoShuoId);
//                shuEntity.setAddrId(addrId);
                shuEntity.setShuJingJieId(shuJingJieId);
                shuEntity.setShuPinJiId(shuPinJiId);
                shuEntity.setShuXiuXing(shuXiuXing);
                String shuInfoId = shuService.saveShu(shuEntity);
                cangKuRequest.put("shuId", shuInfoId);
                shuHisEntity.setShuId(shuInfoId);
                shuHisEntity.setShuCode(shuEntity.getShuCode());
                shuHisEntity.setUpdateTime(shuEntity.getUpdateTime());
                String shuHisId = shuHisService.saveOrUpdateShuHis(shuHisEntity);
                shuHisEntity.setId(shuHisId);
                cangKuRequest.put("shuHisId", shuHisId);
            }
        }
        return true;
    }
}
