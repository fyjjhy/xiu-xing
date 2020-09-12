package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.LingWuEntity;
import com.hbasesoft.xiu.xing.entity.LingWuHisEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.entity.SuoShuEntity;
import com.hbasesoft.xiu.xing.entity.SuoShuHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.HenJiService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.LingWuHisService;
import com.hbasesoft.xiu.xing.service.LingWuService;
import com.hbasesoft.xiu.xing.service.PinJiService;
import com.hbasesoft.xiu.xing.service.SuoShuHisService;
import com.hbasesoft.xiu.xing.service.SuoShuService;
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
    private LingWuService lingWuService;

    @Resource
    private LingWuHisService lingWuHisService;

    @Resource
    private SuoShuService suoShuService;

    @Resource
    private SuoShuHisService suoShuHisService;

    @Resource
    private JingJieService jingJieService;

    @Resource
    private PinJiService pinJiService;

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private HenJiService henJiService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuRequest = flowBean.getRequest();
        if (MapUtils.isNotEmpty(cangKuRequest)) {
            String lingWuId = (String) cangKuRequest.get("lingWuId");
            String lingWuFenLei = (String) cangKuRequest.get("lingWuFenLei");
            String lingWuName = (String) cangKuRequest.get("lingWuName");
            String lingWuMiaoShu = (String) cangKuRequest.get("lingWuMiaoShu");
            String xiaoShuoId = (String) cangKuRequest.get("xiaoShuoId");
            String xiuXingSuiYue = (String) cangKuRequest.get("xiuXingSuiYue");
            LingWuHisEntity lingWuHisEntity = new LingWuHisEntity();
            lingWuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            lingWuHisEntity.setXiaoShuoId(xiaoShuoId);
            lingWuHisEntity.setLingWuMiaoShu(lingWuMiaoShu);
            lingWuHisEntity.setLingWuFenLei(lingWuFenLei);
            lingWuHisEntity.setLingWuName(lingWuName);
            lingWuHisEntity.setXiuXingSuiYue(xiuXingSuiYue);
            if (StringUtils.isNotEmpty(lingWuId)) {
                LingWuEntity lingWuEntity = lingWuService.getLingWuById(lingWuId);
                Assert.notNull(lingWuEntity, XiuXingErrorCodeDef.LING_WU_INFO_IS_EMPTY);
                lingWuHisEntity.setLingWuId(lingWuId);
                lingWuHisEntity.setLingWuCode(lingWuEntity.getLingWuCode());
                String lingWuHisId = lingWuHisService.saveOrUpdateLingWuHis(lingWuHisEntity);
                cangKuRequest.put("lingWuHisId", lingWuHisId);
            }
            else {
                LingWuEntity lingWuEntity = new LingWuEntity();
                int lingWuCount = lingWuService.getLingWuCount();
                lingWuEntity.setLingWuCode(String.valueOf(++lingWuCount));
                lingWuEntity.setLingWuName(lingWuName);
                lingWuEntity.setLingWuFenLei(lingWuFenLei);
                // lingWuEntity.setLingWuState(lingWuState);
                // lingWuEntity.setLingWuShuXing(lingWuShuXing);
                lingWuEntity.setLingWuMiaoShu(lingWuMiaoShu);
                lingWuEntity.setUpdateTime(lingWuHisEntity.getUpdateTime());
                lingWuEntity.setXiaoShuoId(xiaoShuoId);
                lingWuEntity.setXiuXingSuiYue(xiuXingSuiYue);
                String lingWuInfoId = lingWuService.saveLingWu(lingWuEntity);
                lingWuHisEntity.setLingWuId(lingWuInfoId);
                lingWuHisEntity.setLingWuCode(lingWuEntity.getLingWuCode());
                lingWuHisEntity.setUpdateTime(lingWuEntity.getUpdateTime());
                String lingWuHisId = lingWuHisService.saveOrUpdateLingWuHis(lingWuHisEntity);
                cangKuRequest.put("lingWuId", lingWuInfoId);
                cangKuRequest.put("lingWuHisId", lingWuHisId);
            }

            String suoShuId = (String) cangKuRequest.get("suoShuId");
            String suoShuFenLei = (String) cangKuRequest.get("suoShuFenLei");
            String suoShuName = (String) cangKuRequest.get("suoShuName");
            String suoShuMiaoShu = (String) cangKuRequest.get("suoShuMiaoShu");
            String addrId = (String) cangKuRequest.get("addrId");
            SuoShuHisEntity suoShuHisEntity = new SuoShuHisEntity();
            suoShuHisEntity.setSuoShuId(suoShuId);
            suoShuHisEntity.setSuoShuFenLei(suoShuFenLei);
            suoShuHisEntity.setSuoShuName(suoShuName);
            suoShuHisEntity.setSuoShuMiaoShu(suoShuMiaoShu);
            suoShuHisEntity.setXiaoShuoId(xiaoShuoId);
            suoShuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
            suoShuHisEntity.setAddrId(addrId);
            if (StringUtils.isNotEmpty(suoShuId)) {
                SuoShuEntity suoShuEntity = suoShuService.getSuoShuById(suoShuId);
                Assert.notNull(suoShuEntity, XiuXingErrorCodeDef.SUO_SHU_INFO_IS_EMPTY);
//                if (!(StringUtils.equals(suoShuName, suoShuEntity.getSuoShuName()) &&
//                        StringUtils.equals(suoShuFenLei, suoShuEntity.getSuoShuFenLei()) &&
//                        StringUtils.equals(suoShuMiaoShu, suoShuEntity.getSuoShuMiaoShu()) &&
//                        StringUtils.equals(xiaoShuoId, suoShuEntity.getXiaoShuoId()))) {
//                    suoShuEntity.setSuoShuName(suoShuName);
//                    suoShuEntity.setSuoShuFenLei(suoShuFenLei);
//                    suoShuEntity.setSuoShuMiaoShu(suoShuMiaoShu);
//                    suoShuEntity.setXiaoShuoId(xiaoShuoId);
//                    suoShuService.updateSuoShu(suoShuEntity);
//                }
                suoShuHisEntity.setSuoShuCode(suoShuEntity.getSuoShuCode());
                String suoShuHisId = suoShuHisService.saveOrUpdateSuoShuHis(suoShuHisEntity);
                cangKuRequest.put("suoShuHisId", suoShuHisId);
            } else {
                SuoShuEntity suoShuEntity = new SuoShuEntity();
                int suoShuCount = suoShuService.getSuoShuCount();
                suoShuEntity.setSuoShuCode(String.valueOf(++suoShuCount));
                suoShuEntity.setSuoShuName(suoShuName);
                suoShuEntity.setSuoShuFenLei(suoShuFenLei);
                suoShuEntity.setSuoShuMiaoShu(suoShuMiaoShu);
                suoShuEntity.setUpdateTime(DateUtil.getCurrentDate());
                suoShuEntity.setXiaoShuoId(xiaoShuoId);
                suoShuEntity.setAddrId(addrId);
                String suoShuInfoId = suoShuService.saveSuoShu(suoShuEntity);
                cangKuRequest.put("suoShuId", suoShuInfoId);
                suoShuHisEntity.setSuoShuId(suoShuInfoId);
                suoShuHisEntity.setSuoShuCode(suoShuEntity.getSuoShuCode());
                suoShuHisEntity.setUpdateTime(suoShuEntity.getUpdateTime());
                String suoShuHisId = suoShuHisService.saveOrUpdateSuoShuHis(suoShuHisEntity);
                cangKuRequest.put("suoShuHisId", suoShuHisId);
            }

            String shiJian = (String) cangKuRequest.get(XiuXingCommonConstant.SHI_JIAN);
            String beiZhu = (String) cangKuRequest.get(XiuXingCommonConstant.BEI_ZHU);
            String henJiId = (String) cangKuRequest.get(XiuXingCommonConstant.HEN_JI_ID);
            HenJiEntity henJiEntity = new HenJiEntity();
            henJiEntity.setShiJian(shiJian);
            henJiEntity.setBeiZhu(beiZhu);
            henJiEntity.setXiaoShuoId(xiaoShuoId);
            if (!(StringUtils.isEmpty(beiZhu) && StringUtils.isEmpty(shiJian))) {
                if (StringUtils.isNotEmpty(henJiId)) {
                    HenJiEntity henJi = henJiService.getHenJi(henJiId);
                    Assert.notNull(henJi, XiuXingErrorCodeDef.HEN_JI_INFO_IS_EMPTY);
                    if (!(StringUtils.equals(shiJian, henJi.getShiJian())
                            && StringUtils.equals(beiZhu, henJi.getBeiZhu())
                            && StringUtils.equals(xiaoShuoId, henJi.getXiaoShuoId()))) {
                        int henJiCount = henJiService.getHenJiCount();
                        henJiEntity.setHenJiCode(String.valueOf(++henJiCount));
                        henJiId = henJiService.saveHenJi(henJiEntity);
                        cangKuRequest.put("henJiId", henJiId);
                    }
                }
                else {
                    int henJiCount = henJiService.getHenJiCount();
                    henJiEntity.setHenJiCode(String.valueOf(++henJiCount));
                    henJiId = henJiService.saveHenJi(henJiEntity);
                    cangKuRequest.put("henJiId", henJiId);
                }
            }
            else {
                cangKuRequest.put("henJiId", null);
            }

            String lingWuJingJieId = (String) cangKuRequest.get(XiuXingCommonConstant.JING_JIE_ID);
            String lingWuPinJiId = (String) cangKuRequest.get(XiuXingCommonConstant.PIN_JI_ID);
            String suoShuJingJieId = (String) cangKuRequest.get(XiuXingCommonConstant.SUO_SHU_JING_JIE_ID);
            String suoShuPinJiId = (String) cangKuRequest.get(XiuXingCommonConstant.SUO_SHU_PIN_JI_ID);
            if (StringUtils.isNotEmpty(lingWuJingJieId)) {
                JingJieEntity jingJieEntity = jingJieService.getJingJieById(lingWuJingJieId);
                cangKuRequest.put("jingJieName", jingJieEntity.getJingJieName());
            }
            else {
                cangKuRequest.put("jingJieName", null);
            }

            if (StringUtils.isNotEmpty(suoShuJingJieId)) {
                JingJieEntity jingJieEntity = jingJieService.getJingJieById(suoShuJingJieId);
                cangKuRequest.put("suoShuJingJieName", jingJieEntity.getJingJieName());
            }
            else {
                cangKuRequest.put("suoShuJingJieName", null);
            }

            if (StringUtils.isNotEmpty(lingWuPinJiId)) {
                PinJiEntity pinJiEntity = pinJiService.getPinJiById(lingWuPinJiId);
                cangKuRequest.put("pinJiName", pinJiEntity.getPinJiName());
            }
            else {
                cangKuRequest.put("pinJiName", null);
            }

            if (StringUtils.isNotEmpty(suoShuPinJiId)) {
                PinJiEntity pinJiEntity = pinJiService.getPinJiById(suoShuPinJiId);
                cangKuRequest.put("suoShuPinJiName", pinJiEntity.getPinJiName());
            }
            else {
                cangKuRequest.put("suoShuPinJiName", null);
            }
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
