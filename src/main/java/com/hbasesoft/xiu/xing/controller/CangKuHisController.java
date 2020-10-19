package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.xiu.xing.api.CangKuHisApi;
import com.hbasesoft.xiu.xing.bean.CangKuHis;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.CongShuService;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import com.hbasesoft.xiu.xing.service.HenJiService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.PinJiService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.api <br>
 * @since V1.0 <br>
 */
@RestController
public class CangKuHisController implements CangKuHisApi {

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private FenLeiService fenLeiService;

    @Resource
    private CongHisService congHisService;

    @Resource
    private JingJieService jingJieService;

    @Resource
    private PinJiService pinJiService;

    @Resource
    private HenJiService henJiService;

    @Resource
    private CongShuService congShuService;

    @Resource
    private ShuHisService shuHisService;

    @Override
    public Map<String, List<CangKuHis>> cangKuCongShuList(@RequestParam("congShuId") String congShuId) {
        Map<String, List<CangKuHis>> result = new HashMap<>();
        // 处理从属仓库信息
        // 场景：属有多个从/从属，其中从属中的属还需要再次递归查询属的从
        processCongShu(congShuId, result);
        return result;
    }

    /**
     * Description: 处理从属<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuId
     * @param result
     * @return <br>
     */
    private void processCongShu(String congShuId, Map<String, List<CangKuHis>> result) {
        List<CangKuHisEntity> cangKuHisEntityList = cangKuHisService.queryCangKuHisByCongShu(congShuId);
        if (CollectionUtils.isNotEmpty(cangKuHisEntityList)) {
            for (CangKuHisEntity hisEntity : cangKuHisEntityList) {
                CangKuHis cangKuHis = new CangKuHis();
                BeanUtils.copyProperties(hisEntity, cangKuHis);
                if (StringUtils.isNotEmpty(hisEntity.getHenJiId())) {
                    HenJiEntity henJiEntity = henJiService.getHenJi(hisEntity.getHenJiId());
                    if (henJiEntity != null) {
                        cangKuHis.setBeiZhu(henJiEntity.getBeiZhu());
                        cangKuHis.setXiuXingShiJian(henJiEntity.getXiuXingShiJian());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getCongJingJieId())) {
                    JingJieEntity jingJieEntity = jingJieService.getJingJieById(hisEntity.getCongJingJieId());
                    if (jingJieEntity != null) {
                        cangKuHis.setCongJingJieName(jingJieEntity.getJingJieName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getCongPinJiId())) {
                    PinJiEntity pinJiEntity = pinJiService.getPinJiById(hisEntity.getCongPinJiId());
                    if (pinJiEntity != null) {
                        cangKuHis.setCongPinJiName(pinJiEntity.getPinJiName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getCongState())) {
                    FenLeiEntity state = fenLeiService.getFenLei(hisEntity.getCongState());
                    if (state != null) {
                        cangKuHis.setCongStateName(state.getFenLeiName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getCongHisId())) {
                    CongHisEntity congHisEntity = congHisService.getCongHis(hisEntity.getCongHisId());
                    if (congHisEntity != null) {
                        cangKuHis.setCongId(congHisEntity.getCongId());
                        cangKuHis.setCongName(congHisEntity.getCongName());
                        cangKuHis.setCongFenLei(congHisEntity.getCongFenLei());
                        cangKuHis.setCongMiaoShu(congHisEntity.getCongMiaoShu());
                        if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                            FenLeiEntity fenLei = fenLeiService.getFenLei(congHisEntity.getCongFenLei());
                            if (fenLei != null) {
                                cangKuHis.setCongFenLeiName(fenLei.getFenLeiName());
                            }
                        }
                        // 判断从信息是否在属信息中存在
                        // 如果存在，则标记链接，打开一个新页面，用来查询从作为属对应的从信息
                        // 如果不存在，则没有任何标记
                        ShuHisEntity shuHisEntity = new ShuHisEntity();
                        shuHisEntity.setShuMiaoShu(congHisEntity.getCongMiaoShu());
                        shuHisEntity.setShuName(congHisEntity.getCongName());
                        shuHisEntity.setShuFenLei(congHisEntity.getCongFenLei());
                        shuHisEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                        List<ShuHisEntity> shuHisEntityList = shuHisService.getShuHisList(shuHisEntity);
                        if (CollectionUtils.isNotEmpty(shuHisEntityList)) {
                            cangKuHis.setType(XiuXingCommonConstant.CONGSHU);
                        }
//                        if (XiuXingCommonConstant.CONGSHU.equals(congShuHisEntity.getCongShuType())) {
//                            processCongShu(congShuHisEntity.getCongShuId(), result);
//                        }
                    }
                }
                if (StringUtils.isEmpty(cangKuHis.getCongFenLeiName())) {
                    LoggerUtil.info("cangKuHis: {0}, congFenLeiName: {1}", cangKuHis, cangKuHis.getCongFenLeiName());
                }
                List<CangKuHis> cangKuHisList = result.get(cangKuHis.getCongFenLeiName());
                if (cangKuHisList == null) {
                    cangKuHisList = new ArrayList<>();
                }
                cangKuHisList.add(cangKuHis);
                result.put(cangKuHis.getCongFenLeiName(), cangKuHisList);
            }
        }
    }

    @Override
    public void syncLingWuSuoShuHisId(@RequestParam("xiaoShuoId") String xiaoShuoId) {
        cangKuHisService.syncLingWuSuoShuHisId(xiaoShuoId);
    }
}
