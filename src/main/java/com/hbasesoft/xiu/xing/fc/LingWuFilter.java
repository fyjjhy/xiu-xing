package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.FaShuEntity;
import com.hbasesoft.xiu.xing.entity.FuLuEntity;
import com.hbasesoft.xiu.xing.entity.GongFaEntity;
import com.hbasesoft.xiu.xing.entity.KuiLeiEntity;
import com.hbasesoft.xiu.xing.entity.LingCaiEntity;
import com.hbasesoft.xiu.xing.entity.LingDanEntity;
import com.hbasesoft.xiu.xing.entity.LingQiEntity;
import com.hbasesoft.xiu.xing.entity.QiTaLingWuEntity;
import com.hbasesoft.xiu.xing.entity.RenWuEntity;
import com.hbasesoft.xiu.xing.entity.YaoShouEntity;
import com.hbasesoft.xiu.xing.entity.ZhenFaEntity;
import com.hbasesoft.xiu.xing.service.FaShuService;
import com.hbasesoft.xiu.xing.service.FuLuService;
import com.hbasesoft.xiu.xing.service.GongFaService;
import com.hbasesoft.xiu.xing.service.KuiLeiService;
import com.hbasesoft.xiu.xing.service.LingCaiService;
import com.hbasesoft.xiu.xing.service.LingDanService;
import com.hbasesoft.xiu.xing.service.LingQiService;
import com.hbasesoft.xiu.xing.service.QiTaLingWuService;
import com.hbasesoft.xiu.xing.service.RenWuService;
import com.hbasesoft.xiu.xing.service.YaoShouService;
import com.hbasesoft.xiu.xing.service.ZhenFaService;
import com.hbasesoft.xiu.xing.util.PagerListVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月08日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("LingWuFilter")
public class LingWuFilter implements ServiceFilter {

    @Resource
    private RenWuService renWuService;

    @Resource
    private QiTaLingWuService qiTaLingWuService;

    @Resource
    private ZhenFaService zhenFaService;

    @Resource
    private YaoShouService yaoShouService;

    @Resource
    private LingQiService lingQiService;

    @Resource
    private LingDanService lingDanService;

    @Resource
    private LingCaiService lingCaiService;

    @Resource
    private KuiLeiService kuiLeiService;

    @Resource
    private GongFaService gongFaService;

    @Resource
    private FaShuService faShuService;

    @Resource
    private FuLuService fuLuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction())) {
            PagerListVo<Map<String, Object>> response = (PagerListVo<Map<String, Object>>) flowBean.getResponse();
            if (response != null) {
                List<Map<String, Object>> resultList = response.getDatas();
                if (CollectionUtils.isNotEmpty(resultList)) {
                    for (Map<String, Object> result : resultList) {
                        processLingWuFenLei(result);
                    }
                    response.setDatas(resultList);
                    flowBean.setResponse(response);
                }
            }
        } else if (ServiceFlowBean.ACTION_GET.equals(flowBean.getAction())) {
            Map<String, Object> response = (Map<String, Object>) flowBean.getResponse();
            if (MapUtils.isNotEmpty(response)) {
                processLingWuFenLei(response);
                flowBean.setResponse(response);
            }
        }
    }

    /**
     * Description: 处理所属分类信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param result
     * @return <br>
     */
    private void processLingWuFenLei(Map<String, Object> result) {
        String lingWuFenLei = (String) result.get(XiuXingCommonConstant.LING_WU_FEN_LEI);
        String lingWuId = (String) result.get(XiuXingCommonConstant.LING_WU_ID);
        if (StringUtils.isNotEmpty(lingWuFenLei)) {
            switch (lingWuFenLei) {
                case XiuXingCommonConstant.YAO_SHOU:
                    YaoShouEntity yaoShou = yaoShouService.getYaoShouById(lingWuId);
                    Assert.notNull(yaoShou, XiuXingErrorCodeDef.YAO_SHOU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, yaoShou.getYaoShouCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, yaoShou.getYaoShouShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, yaoShou.getYaoShouMiaoShu());
                    break;
                case XiuXingCommonConstant.FU_LU:
                    FuLuEntity fuLu = fuLuService.getFuLuById(lingWuId);
                    Assert.notNull(fuLu, XiuXingErrorCodeDef.FU_LU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, fuLu.getFuLuCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, fuLu.getFuLuShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, fuLu.getFuLuMiaoShu());
                    break;
                case XiuXingCommonConstant.GONG_FA:
                    GongFaEntity gongFa = gongFaService.getGongFaById(lingWuId);
                    Assert.notNull(gongFa, XiuXingErrorCodeDef.GONG_FA_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, gongFa.getGongFaCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, gongFa.getGongFaShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, gongFa.getGongFaMiaoShu());
                    break;
                case XiuXingCommonConstant.FA_SHU:
                    FaShuEntity faShu = faShuService.getFaShuById(lingWuId);
                    Assert.notNull(faShu, XiuXingErrorCodeDef.FA_SHU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, faShu.getFaShuCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, faShu.getFaShuShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, faShu.getFaShuMiaoShu());
                    break;
                case XiuXingCommonConstant.FA_QI:
                    LingQiEntity lingQi = lingQiService.getLingQiById(lingWuId);
                    Assert.notNull(lingQi, XiuXingErrorCodeDef.LING_QI_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, lingQi.getLingQiCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, lingQi.getLingQiShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, lingQi.getLingQiMiaoShu());
                    break;
                case XiuXingCommonConstant.QI_TA_LING_WU:
                    QiTaLingWuEntity qiTaLingWu = qiTaLingWuService.getQiTaLingWuById(lingWuId);
                    Assert.notNull(qiTaLingWu, XiuXingErrorCodeDef.QI_TA_LING_WU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, qiTaLingWu.getLingWuCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, qiTaLingWu.getLingWuShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, qiTaLingWu.getLingWuMiaoShu());
                    break;
                case XiuXingCommonConstant.LING_DAN:
                    LingDanEntity lingDan = lingDanService.getLingDanById(lingWuId);
                    Assert.notNull(lingDan, XiuXingErrorCodeDef.LING_DAN_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, lingDan.getLingDanCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, lingDan.getLingDanShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, lingDan.getLingDanMiaoShu());
                    break;
                case XiuXingCommonConstant.LING_CAI:
                    LingCaiEntity lingCai = lingCaiService.getLingCaiById(lingWuId);
                    Assert.notNull(lingCai, XiuXingErrorCodeDef.LING_CAI_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, lingCai.getLingCaiCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, lingCai.getLingCaiShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, lingCai.getLingCaiMiaoShu());
                    break;
                case XiuXingCommonConstant.KUI_LEI:
                    KuiLeiEntity kuiLei = kuiLeiService.getKuiLeiById(lingWuId);
                    Assert.notNull(kuiLei, XiuXingErrorCodeDef.KUI_LEI_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, kuiLei.getKuiLeiCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, kuiLei.getKuiLeiShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, kuiLei.getKuiLeiMiaoShu());
                    break;
                case XiuXingCommonConstant.ZHEN_FA:
                    ZhenFaEntity zhenFa = zhenFaService.getZhenFaById(lingWuId);
                    Assert.notNull(zhenFa, XiuXingErrorCodeDef.ZHEN_FA_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, zhenFa.getZhenFaCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, zhenFa.getZhenFaShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, zhenFa.getZhenFaMiaoShu());
                    break;
                case XiuXingCommonConstant.REN_WU:
                    RenWuEntity renWu = renWuService.getRenWuById(lingWuId);
                    Assert.notNull(renWu, XiuXingErrorCodeDef.REN_WU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.LING_WU_CODE, renWu.getRenWuCode());
                    result.put(XiuXingCommonConstant.LING_WU_SHU_XING, renWu.getRenWuShuXing());
                    result.put(XiuXingCommonConstant.LING_WU_MIAO_SHU, renWu.getRenWuMiaoShu());
                    break;
            }
        }
    }
}
