package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.CongShuInfo;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.AddressEntity;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
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
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <Description> 章节Get过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ZhangJieGetFilter")
public class ZhangJieGetFilter implements ServiceFilter {

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
        Map<String, Object> zhangJieMap = (Map<String, Object>) flowBean.getResponse();
        if (MapUtils.isNotEmpty(zhangJieMap)) {
            String zhangJieId = (String) zhangJieMap.get(XiuXingCommonConstant.ID);
            List<ZhangJieCongShuEntity> zhangJieCongShuEntityList = zhangJieCongShuService.getZhangJieCongShuListByZhangJieId(zhangJieId);
            if (CollectionUtils.isNotEmpty(zhangJieCongShuEntityList)) {
                Set<String> congInfoSet = new HashSet<>();
                Set<String> shuInfoSet = new HashSet<>();
                Set<String> fullNameSet = new HashSet<>();
                Map<String, CongShuInfo> congHisIdMap = new HashMap<>();
                Map<String, CongShuInfo> shuHisIdMap = new HashMap<>();
                Map<String, CongShuInfo> cangKuHisIdMap = new HashMap<>();
                for (ZhangJieCongShuEntity zhangJieCongShuEntity : zhangJieCongShuEntityList) {
                    if (StringUtils.isNotEmpty(zhangJieCongShuEntity.getCongShuHisId())) {
                        String addrId = zhangJieCongShuEntity.getAddrId();
                        String fullName = null;
                        if (StringUtils.isNotEmpty(addrId)) {
                            AddressEntity addressEntity = addressService.getAddress(addrId);
                            if (addressEntity != null) {
                                fullName = addressEntity.getFullName();
                                fullNameSet.add(addressEntity.getFullName());
                            }
                        }
                        if (XiuXingCommonConstant.CONG_SHU_CONG.equals(zhangJieCongShuEntity.getType())) {
                            CongShuInfo congShuInfo = congHisIdMap.get(zhangJieCongShuEntity.getCongShuHisId());
                            if (congShuInfo == null) {
                                CongHisEntity congHisEntity = congHisService.getCongHis(zhangJieCongShuEntity.getCongShuHisId());
                                if (congHisEntity != null) {
                                    congShuInfo = new CongShuInfo();
                                    congShuInfo.setCongShuId(congHisEntity.getCongId());
                                    congShuInfo.setCongShuHisId(congHisEntity.getId());
                                    congShuInfo.setCongShuName(congHisEntity.getCongName());
                                    congShuInfo.setCongShuFenLei(congHisEntity.getCongFenLei());
                                    congShuInfo.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
                                    congShuInfo.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                                    congShuInfo.setCongShuType("从");
                                    StringBuilder congInfoName = new StringBuilder();
                                    if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                                        FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(congHisEntity.getCongFenLei());
                                        if (fenLeiEntity != null) {
                                            congInfoName.append(fenLeiEntity.getFenLeiName());
                                            congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                                        }
                                    }

                                    if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
                                        XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(congHisEntity.getXiaoShuoId());
                                        if (xiaoShuoEntity != null) {
                                            congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                                        }
                                    }

                                    congInfoName.append(congHisEntity.getCongName());
                                    congInfoSet.add(congInfoName.toString());
                                }
                            }

                            if (congShuInfo != null) {
                                List<String> fullNameList = congShuInfo.getFullNames();
                                if (fullNameList == null) {
                                    fullNameList = new ArrayList<>();
                                }
                                if (!fullNameList.contains(fullName)) {
                                    fullNameList.add(fullName);
                                    congShuInfo.setFullNames(fullNameList);
                                }

                                List<String> addrIdList = congShuInfo.getAddrIds();
                                if (addrIdList == null) {
                                    addrIdList = new ArrayList<>();
                                }
                                if (!addrIdList.contains(addrId)) {
                                    addrIdList.add(addrId);
                                    congShuInfo.setAddrIds(addrIdList);
                                }
                                congHisIdMap.put(zhangJieCongShuEntity.getCongShuHisId(), congShuInfo);
                            }
                        }
                        else if (XiuXingCommonConstant.CONG_SHU_SHU.equals(zhangJieCongShuEntity.getType())) {
                            CongShuInfo congShuInfo = shuHisIdMap.get(zhangJieCongShuEntity.getCongShuHisId());
                            if (congShuInfo == null) {
                                ShuHisEntity shuHisEntity = shuHisService.getShuHis(zhangJieCongShuEntity.getCongShuHisId());
                                if (shuHisEntity != null) {
                                    congShuInfo = new CongShuInfo();
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
                                    StringBuilder shuInfoName = new StringBuilder();
                                    if (StringUtils.isNotEmpty(shuHisEntity.getShuState())) {
                                        FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(shuHisEntity.getShuState());
                                        if (fenLeiEntity != null) {
                                            shuInfoName.append("[").append(fenLeiEntity.getFenLeiName()).append("]");
                                            congShuInfo.setCongShuStateName(fenLeiEntity.getFenLeiName());
                                        }
                                    }

                                    if (StringUtils.isNotEmpty(shuHisEntity.getShuJingJieId())) {
                                        JingJieEntity jingJieEntity = jingJieService.getJingJieById(shuHisEntity.getShuJingJieId());
                                        if (jingJieEntity != null) {
                                            shuInfoName.append(jingJieEntity.getJingJieName());
                                            congShuInfo.setCongShuJingJieName(jingJieEntity.getJingJieName());
                                        }
                                    }

                                    if (StringUtils.isNotEmpty(shuHisEntity.getShuPinJiId())) {
                                        PinJiEntity pinJiEntity = pinJiService.getPinJiById(shuHisEntity.getShuPinJiId());
                                        if (pinJiEntity != null) {
                                            shuInfoName.append(pinJiEntity.getPinJiName());
                                            congShuInfo.setCongShuPinJiName(pinJiEntity.getPinJiName());
                                        }
                                    }

                                    if (StringUtils.isNotEmpty(shuHisEntity.getShuFenLei())) {
                                        FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(shuHisEntity.getShuFenLei());
                                        if (fenLeiEntity != null) {
                                            shuInfoName.append(fenLeiEntity.getFenLeiName());
                                            congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                                        }
                                    }

                                    if (StringUtils.isNotEmpty(shuHisEntity.getXiaoShuoId())) {
                                        XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(shuHisEntity.getXiaoShuoId());
                                        if (xiaoShuoEntity != null) {
                                            congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                                        }
                                    }

                                    shuInfoName.append(shuHisEntity.getShuName());
                                    shuInfoSet.add(shuInfoName.toString());
                                }
                            }

                            if (congShuInfo != null) {
                                List<String> fullNameList = congShuInfo.getFullNames();
                                if (fullNameList == null) {
                                    fullNameList = new ArrayList<>();
                                }
                                if (!fullNameList.contains(fullName)) {
                                    fullNameList.add(fullName);
                                    congShuInfo.setFullNames(fullNameList);
                                }

                                List<String> addrIdList = congShuInfo.getAddrIds();
                                if (addrIdList == null) {
                                    addrIdList = new ArrayList<>();
                                }
                                if (!addrIdList.contains(addrId)) {
                                    addrIdList.add(addrId);
                                    congShuInfo.setAddrIds(addrIdList);
                                }
                                shuHisIdMap.put(zhangJieCongShuEntity.getCongShuHisId(), congShuInfo);
                            }
                        }
                        else if (XiuXingCommonConstant.CANG_CONG.equals(zhangJieCongShuEntity.getType())) {
                            CongShuInfo congShuInfo = cangKuHisIdMap.get(zhangJieCongShuEntity.getCongShuHisId());
                            if (congShuInfo == null) {
                                CangKuHisEntity cangKuHisEntity = cangKuHisService.getCangKuHis(zhangJieCongShuEntity.getCongShuHisId());
                                if (cangKuHisEntity != null) {
                                    CongHisEntity congHisEntity = congHisService.getCongHis(cangKuHisEntity.getCongHisId());
                                    if (congHisEntity != null) {
                                        congShuInfo = new CongShuInfo();
                                        congShuInfo.setCangKuHisId(cangKuHisEntity.getId());
                                        congShuInfo.setCongShuHisId(congHisEntity.getId());
                                        congShuInfo.setCongShuId(congHisEntity.getCongId());
                                        congShuInfo.setCongShuName(congHisEntity.getCongName());
                                        congShuInfo.setCongShuShuXing(cangKuHisEntity.getCongShuXing());
                                        congShuInfo.setCongShuState(cangKuHisEntity.getCongState());
                                        congShuInfo.setCongShuJingJieId(cangKuHisEntity.getCongJingJieId());
                                        congShuInfo.setCongShuPinJiId(cangKuHisEntity.getCongPinJiId());
                                        congShuInfo.setCongShuFenLei(congHisEntity.getCongFenLei());
                                        congShuInfo.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
                                        congShuInfo.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                                        congShuInfo.setCongShuType("仓从");
                                        StringBuilder shuInfoName = new StringBuilder();
                                        if (StringUtils.isNotEmpty(cangKuHisEntity.getCongState())) {
                                            FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(cangKuHisEntity.getCongState());
                                            if (fenLeiEntity != null) {
                                                shuInfoName.append("[").append(fenLeiEntity.getFenLeiName()).append("]");
                                                congShuInfo.setCongShuStateName(fenLeiEntity.getFenLeiName());
                                            }
                                        }

                                        if (StringUtils.isNotEmpty(cangKuHisEntity.getCongShuXing())) {
                                            shuInfoName.append("(").append(cangKuHisEntity.getCongShuXing()).append(")");
                                        }

                                        if (StringUtils.isNotEmpty(cangKuHisEntity.getCongJingJieId())) {
                                            JingJieEntity jingJieEntity = jingJieService.getJingJieById(cangKuHisEntity.getCongJingJieId());
                                            if (jingJieEntity != null) {
                                                shuInfoName.append(jingJieEntity.getJingJieName());
                                                congShuInfo.setCongShuJingJieName(jingJieEntity.getJingJieName());
                                            }
                                        }

                                        if (StringUtils.isNotEmpty(cangKuHisEntity.getCongPinJiId())) {
                                            PinJiEntity pinJiEntity = pinJiService.getPinJiById(cangKuHisEntity.getCongPinJiId());
                                            if (pinJiEntity != null) {
                                                shuInfoName.append(pinJiEntity.getPinJiName());
                                                congShuInfo.setCongShuPinJiName(pinJiEntity.getPinJiName());
                                            }
                                        }

                                        if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                                            FenLeiEntity fenLeiEntity = fenLeiService.getFenLei(congHisEntity.getCongFenLei());
                                            if (fenLeiEntity != null) {
                                                shuInfoName.append(fenLeiEntity.getFenLeiName());
                                                congShuInfo.setCongShuFenLeiName(fenLeiEntity.getFenLeiName());
                                            }
                                        }

                                        if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
                                            XiaoShuoEntity xiaoShuoEntity = xiaoShuoService.getXiaoShuo(congHisEntity.getXiaoShuoId());
                                            if (xiaoShuoEntity != null) {
                                                congShuInfo.setXiaoShuoName(xiaoShuoEntity.getName());
                                            }
                                        }

                                        shuInfoName.append(congHisEntity.getCongName());
                                        congInfoSet.add(shuInfoName.toString());
                                    }
                                }
                            }

                            if (congShuInfo != null) {
                                List<String> fullNameList = congShuInfo.getFullNames();
                                if (fullNameList == null) {
                                    fullNameList = new ArrayList<>();
                                }
                                if (!fullNameList.contains(fullName)) {
                                    fullNameList.add(fullName);
                                    congShuInfo.setFullNames(fullNameList);
                                }

                                List<String> addrIdList = congShuInfo.getAddrIds();
                                if (addrIdList == null) {
                                    addrIdList = new ArrayList<>();
                                }
                                if (!addrIdList.contains(addrId)) {
                                    addrIdList.add(addrId);
                                    congShuInfo.setAddrIds(addrIdList);
                                }
                                cangKuHisIdMap.put(zhangJieCongShuEntity.getCongShuHisId(), congShuInfo);
                            }
                        }
                    }
                }

                if (!congInfoSet.isEmpty()) {
                    zhangJieMap.put("congInfoName", String.join("\r\n", new ArrayList<>(congInfoSet)));
                }

                if (!shuInfoSet.isEmpty()) {
                    zhangJieMap.put("shuInfoName", String.join("\r\n", new ArrayList<>(shuInfoSet)));
                }

                if (!fullNameSet.isEmpty()) {
                    zhangJieMap.put("fullName", String.join("\r\n", new ArrayList<>(fullNameSet)));
                }

                if (MapUtils.isNotEmpty(congHisIdMap) || MapUtils.isNotEmpty(cangKuHisIdMap)) {
                    List<CongShuInfo> congShuInfoList = new ArrayList<>();
                    if (MapUtils.isNotEmpty(congHisIdMap)) {
                        congHisIdMap.forEach(((congHisId, congShuInfo) -> {
                            congShuInfoList.add(congShuInfo);
                        }));
                    }

                    if (MapUtils.isNotEmpty(cangKuHisIdMap)) {
                        cangKuHisIdMap.forEach((cangKuHisId, congShuInfo) -> {
                            congShuInfoList.add(congShuInfo);
                        });
                    }
                    zhangJieMap.put("congInfo", congShuInfoList);
                }

                if (MapUtils.isNotEmpty(shuHisIdMap)) {
                    List<CongShuInfo> congShuInfoList = new ArrayList<>();
                    shuHisIdMap.forEach((shuHisId, congShuInfo) -> {
                        congShuInfoList.add(congShuInfo);
                    });
                    zhangJieMap.put("shuInfo", congShuInfoList);
                }
            }
        }
    }
}
