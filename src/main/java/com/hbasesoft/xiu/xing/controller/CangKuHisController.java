package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.CangKuHisApi;
import com.hbasesoft.xiu.xing.bean.CangKuHis;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.LingWuHisEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import com.hbasesoft.xiu.xing.service.HenJiService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.LingWuHisService;
import com.hbasesoft.xiu.xing.service.PinJiService;
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
    private LingWuHisService lingWuHisService;

    @Resource
    private JingJieService jingJieService;

    @Resource
    private PinJiService pinJiService;

    @Resource
    private HenJiService henJiService;

    @Override
    public Map<String, List<CangKuHis>> queryCangKuHisBySuoShu(@RequestParam("suoShuId") String suoShuId) {
        List<CangKuHisEntity> cangKuHisEntityList = cangKuHisService.queryCangKuHisBySuoShu(suoShuId);
        Map<String, List<CangKuHis>> result = new HashMap<>();
        if (CollectionUtils.isNotEmpty(cangKuHisEntityList)) {
            for (CangKuHisEntity hisEntity : cangKuHisEntityList) {
                CangKuHis cangKuHis = new CangKuHis();
                BeanUtils.copyProperties(hisEntity, cangKuHis);
                if (StringUtils.isNotEmpty(hisEntity.getHenJiId())) {
                    HenJiEntity henJiEntity = henJiService.getHenJi(hisEntity.getHenJiId());
                    if (henJiEntity != null) {
                        cangKuHis.setBeiZhu(henJiEntity.getBeiZhu());
                        cangKuHis.setShiJian(henJiEntity.getShiJian());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getJingJieId())) {
                    JingJieEntity jingJieEntity = jingJieService.getJingJieById(hisEntity.getJingJieId());
                    if (jingJieEntity != null) {
                        cangKuHis.setJingJieName(jingJieEntity.getJingJieName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getPinJiId())) {
                    PinJiEntity pinJiEntity = pinJiService.getPinJiById(hisEntity.getPinJiId());
                    if (pinJiEntity != null) {
                        cangKuHis.setPinJiName(pinJiEntity.getPinJiName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getLingWuState())) {
                    FenLeiEntity state = fenLeiService.getFenLei(hisEntity.getLingWuState());
                    if (state != null) {
                        cangKuHis.setLingWuStateName(state.getFenLeiName());
                    }
                }

                if (StringUtils.isNotEmpty(hisEntity.getLingWuHisId())) {
                    LingWuHisEntity lingWuHisEntity = lingWuHisService.getLingWuHis(hisEntity.getLingWuHisId());
                    if (lingWuHisEntity != null) {
                        cangKuHis.setLingWuId(lingWuHisEntity.getLingWuId());
                        cangKuHis.setLingWuName(lingWuHisEntity.getLingWuName());
                        cangKuHis.setLingWuFenLei(lingWuHisEntity.getLingWuFenLei());
                        cangKuHis.setLingWuMiaoShu(lingWuHisEntity.getLingWuMiaoShu());
                        if (StringUtils.isNotEmpty(lingWuHisEntity.getLingWuFenLei())) {
                            FenLeiEntity fenLei = fenLeiService.getFenLei(lingWuHisEntity.getLingWuFenLei());
                            if (fenLei != null) {
                                cangKuHis.setLingWuFenLeiName(fenLei.getFenLeiName());
                            }
                        }
                    }
                }
                List<CangKuHis> cangKuHisList = result.get(cangKuHis.getLingWuFenLeiName());
                if (cangKuHisList == null) {
                    cangKuHisList = new ArrayList<>();
                }
                cangKuHisList.add(cangKuHis);
                result.put(cangKuHis.getLingWuFenLeiName(), cangKuHisList);
            }
        }
        return result;
    }

    @Override
    public void syncLingWuSuoShuHisId(@RequestParam("xiaoShuoId") String xiaoShuoId) {
        cangKuHisService.syncLingWuSuoShuHisId(xiaoShuoId);
    }
}
