package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.CongShuInfo;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import com.hbasesoft.xiu.xing.service.AddressService;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.PinJiService;
import com.hbasesoft.xiu.xing.service.ShuHisService;
import com.hbasesoft.xiu.xing.service.XiaoShuoService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <Description> 章节Info过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CongShuGuiJiFilter")
public class CongShuGuiJiFilter implements ServiceFilter {

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Resource
    private FenLeiService fenLeiService;

    @Resource
    private JingJieService jingJieService;

    @Resource
    private PinJiService pinJiService;

    @Resource
    private AddressService addressService;

    @Resource
    private CongHisService congHisService;

    @Resource
    private ShuHisService shuHisService;

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private XiaoShuoService xiaoShuoService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        // 获取单条数据
        List<Map<String, Object>> congShuGuiJiList = (List<Map<String, Object>>) flowBean.getResponse();
        if (CollectionUtils.isNotEmpty(congShuGuiJiList)) {
            List<Map<String, Object>> congShuGuiJiInfoList = new ArrayList<>();
            for (Map<String, Object> congShuGuiJiMap : congShuGuiJiList) {
                String addrFullName = (String) congShuGuiJiMap.get("addrFullName");
                if (StringUtils.isEmpty(addrFullName)) {
                    addrFullName = "未归属";
                }
                String congShuType = (String) congShuGuiJiMap.get("type");
                String congShuHisId = (String) congShuGuiJiMap.get("congShuHisId");
                String cangKuHisId = (String) congShuGuiJiMap.get("cangKuHisId");
                String zhangJieId = (String) congShuGuiJiMap.get("zhangJieId");
                String zhangJieTitle = (String) congShuGuiJiMap.get("zhangJieTitle");
                if (XiuXingCommonConstant.CONG_SHU_CONG.equals(congShuType)
                        && StringUtils.isNotEmpty(congShuHisId)) {
                    CongHisEntity congHisEntity = congHisService.getCongHis(congShuHisId);
                    if (congHisEntity != null) {
                        CongShuInfo congShuInfo = new CongShuInfo();
                        congShuInfo.setCongShuId(congHisEntity.getCongId());
                        congShuInfo.setCongShuHisId(congHisEntity.getId());
                        congShuInfo.setCongShuName(congHisEntity.getCongName());
                        congShuInfo.setCongShuFenLei(congHisEntity.getCongFenLei());
                        congShuInfo.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
                        congShuInfo.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                        congShuInfo.setCongShuType("从");
                        congShuInfo.setAddrFullName(addrFullName);
                        congShuInfo.setZhangJieId(zhangJieId);
                        congShuInfo.setZhangJieTitle(zhangJieTitle);
                        if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                            FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(congHisEntity.getCongFenLei());
                            if (fenLeiEntity != null) {
                                congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                            }
                        }

                        if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
                            XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(congHisEntity.getXiaoShuoId());
                            if (xiaoShuoEntity != null) {
                                congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                            }
                        }
                        Map<String, Object> congShuInfoMap = JSON.parseObject(JSON.toJSONString(congShuInfo), new TypeReference<Map<String, Object>>(){});
                        congShuGuiJiInfoList.add(congShuInfoMap);
                    }
                }
                else if (XiuXingCommonConstant.CONG_SHU_SHU.equals(congShuType)
                        && StringUtils.isNotEmpty(congShuHisId)) {
                    ShuHisEntity shuHisEntity = shuHisService.getShuHis(congShuHisId);
                    if (shuHisEntity != null) {
                        CongShuInfo congShuInfo = new CongShuInfo();
                        congShuInfo.setCongShuHisId(shuHisEntity.getId());
                        congShuInfo.setCongShuId(shuHisEntity.getShuId());
                        congShuInfo.setCongShuName(shuHisEntity.getShuName());
                        congShuInfo.setCongShuState(shuHisEntity.getShuState());
                        congShuInfo.setCongShuJingJieId(shuHisEntity.getShuJingJieId());
                        congShuInfo.setCongShuPinJiId(shuHisEntity.getShuPinJiId());
                        congShuInfo.setCongShuFenLei(shuHisEntity.getShuFenLei());
                        congShuInfo.setCongShuXiuXing(shuHisEntity.getShuXiuXing());
                        congShuInfo.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
                        congShuInfo.setCongShuMiaoShu(shuHisEntity.getShuMiaoShu());
                        congShuInfo.setCongShuType("属");
                        congShuInfo.setAddrFullName(addrFullName);
                        congShuInfo.setZhangJieId(zhangJieId);
                        congShuInfo.setZhangJieTitle(zhangJieTitle);
                        if (StringUtils.isNotEmpty(shuHisEntity.getShuState())) {
                            FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(shuHisEntity.getShuState());
                            if (fenLeiEntity != null) {
                                congShuInfo.setCongShuStateName(fenLeiEntity.getFenLeiName());
                            }
                        }

                        if (StringUtils.isNotEmpty(shuHisEntity.getShuJingJieId())) {
                            JingJieEntity jingJieEntity = jingJieService.getJingJieById(shuHisEntity.getShuJingJieId());
                            if (jingJieEntity != null) {
                                congShuInfo.setCongShuJingJieName(jingJieEntity.getJingJieName());
                            }
                        }

                        if (StringUtils.isNotEmpty(shuHisEntity.getShuPinJiId())) {
                            PinJiEntity pinJiEntity = pinJiService.getPinJiById(shuHisEntity.getShuPinJiId());
                            if (pinJiEntity != null) {
                                congShuInfo.setCongShuPinJiName(pinJiEntity.getPinJiName());
                            }
                        }

                        if (StringUtils.isNotEmpty(shuHisEntity.getShuFenLei())) {
                            FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(shuHisEntity.getShuFenLei());
                            if (fenLeiEntity != null) {
                                congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                            }
                        }

                        if (StringUtils.isNotEmpty(shuHisEntity.getXiaoShuoId())) {
                            XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(shuHisEntity.getXiaoShuoId());
                            if (xiaoShuoEntity != null) {
                                congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                            }
                        }
                        Map<String, Object> congShuInfoMap = JSON.parseObject(JSON.toJSONString(congShuInfo), new TypeReference<Map<String, Object>>(){});
                        congShuGuiJiInfoList.add(congShuInfoMap);
                    }
                }
                else if (XiuXingCommonConstant.CANG_CONG.equals(congShuType)
                        && StringUtils.isNotEmpty(cangKuHisId)) {
                    CangKuHisEntity cangKuHisEntity = cangKuHisService.getCangKuHis(cangKuHisId);
                    if (cangKuHisEntity != null) {
                        CongHisEntity congHisEntity = congHisService.getCongHis(cangKuHisEntity.getCongHisId());
                        if (congHisEntity != null) {
                            CongShuInfo congShuInfo = new CongShuInfo();
                            congShuInfo.setCongShuHisId(congHisEntity.getId());
                            congShuInfo.setCongShuId(congHisEntity.getCongId());
                            congShuInfo.setCongShuName(congHisEntity.getCongName());
                            congShuInfo.setCongShuShuXing(cangKuHisEntity.getCongShuXing());
                            congShuInfo.setCongShuXiuXing(cangKuHisEntity.getCongXiuXing());
                            congShuInfo.setCongShuState(cangKuHisEntity.getCongState());
                            congShuInfo.setCongShuJingJieId(cangKuHisEntity.getCongJingJieId());
                            congShuInfo.setCongShuPinJiId(cangKuHisEntity.getCongPinJiId());
                            congShuInfo.setCongShuFenLei(congHisEntity.getCongFenLei());
                            congShuInfo.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
                            congShuInfo.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                            congShuInfo.setCongShuType("仓从");
                            congShuInfo.setAddrFullName(addrFullName);
                            congShuInfo.setZhangJieId(zhangJieId);
                            congShuInfo.setZhangJieTitle(zhangJieTitle);
                            if (StringUtils.isNotEmpty(cangKuHisEntity.getCongState())) {
                                FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(cangKuHisEntity.getCongState());
                                if (fenLeiEntity != null) {
                                    congShuInfo.setCongShuStateName(fenLeiEntity.getFenLeiName());
                                }
                            }

                            if (StringUtils.isNotEmpty(cangKuHisEntity.getCongJingJieId())) {
                                JingJieEntity jingJieEntity = jingJieService.getJingJieById(cangKuHisEntity.getCongJingJieId());
                                if (jingJieEntity != null) {
                                    congShuInfo.setCongShuJingJieName(jingJieEntity.getJingJieName());
                                }
                            }

                            if (StringUtils.isNotEmpty(cangKuHisEntity.getCongPinJiId())) {
                                PinJiEntity pinJiEntity = pinJiService.getPinJiById(cangKuHisEntity.getCongPinJiId());
                                if (pinJiEntity != null) {
                                    congShuInfo.setCongShuPinJiName(pinJiEntity.getPinJiName());
                                }
                            }

                            if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                                FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(congHisEntity.getCongFenLei());
                                if (fenLeiEntity != null) {
                                    congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                                }
                            }

                            if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
                                XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(congHisEntity.getXiaoShuoId());
                                if (xiaoShuoEntity != null) {
                                    congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                                }
                            }
                            Map<String, Object> congShuInfoMap = JSON.parseObject(JSON.toJSONString(congShuInfo), new TypeReference<Map<String, Object>>(){});
                            congShuGuiJiInfoList.add(congShuInfoMap);
                        }
                    }
                }
            }
            flowBean.setResponse(congShuGuiJiInfoList);
        }

    }
}
