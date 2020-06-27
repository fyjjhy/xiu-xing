package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.service.DiMingService;
import com.hbasesoft.xiu.xing.service.FaShuService;
import com.hbasesoft.xiu.xing.service.FuLuService;
import com.hbasesoft.xiu.xing.service.GongFaService;
import com.hbasesoft.xiu.xing.service.JiGouService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.KuiLeiService;
import com.hbasesoft.xiu.xing.service.LingCaiService;
import com.hbasesoft.xiu.xing.service.LingDanService;
import com.hbasesoft.xiu.xing.service.LingQiService;
import com.hbasesoft.xiu.xing.service.LingWuService;
import com.hbasesoft.xiu.xing.service.QiTaLingWuService;
import com.hbasesoft.xiu.xing.service.RenWuService;
import com.hbasesoft.xiu.xing.service.SheDingService;
import com.hbasesoft.xiu.xing.service.SuoShuService;
import com.hbasesoft.xiu.xing.service.XiuXingRiZhiService;
import com.hbasesoft.xiu.xing.service.YaoShouService;
import com.hbasesoft.xiu.xing.service.ZhenFaService;
import com.hbasesoft.xiu.xing.service.ZongMenService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
@Component("CodeFilter")
public class CodeFilter implements ServiceFilter {

    @Resource
    private RenWuService renWuService;

    @Resource
    private JingJieService jingJieService;

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

    @Resource
    private SheDingService sheDingService;

    @Resource
    private ZongMenService zongMenService;

    @Resource
    private JiGouService jiGouService;

    @Resource
    private DiMingService diMingService;

    @Resource
    private SuoShuService suoShuService;

    @Resource
    private LingWuService lingWuService;

    @Resource
    private XiuXingRiZhiService xiuXingRiZhiService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> request = flowBean.getRequest();
        if (request.containsKey(XiuXingCommonConstant.FUNC_MODEL_CODE)) {
            String funcModelCode = (String) request.get(XiuXingCommonConstant.FUNC_MODEL_CODE);
            if (XiuXingCommonConstant.REN_WU.equals(funcModelCode)) {
                int renWuCount = renWuService.getRenWuCount();
                request.put(XiuXingCommonConstant.REN_WU_CODE, renWuCount + 1);
            } else if (XiuXingCommonConstant.JING_JIE.equals(funcModelCode)) {
                int jingJieCount = jingJieService.getJingJieCount();
                request.put(XiuXingCommonConstant.JING_JIE_CODE, jingJieCount + 1);
            } else if (XiuXingCommonConstant.QI_TA_LING_WU.equals(funcModelCode)) {
                int qiTaLingWuCount = qiTaLingWuService.getQiTaLingWuCount();
                request.put(XiuXingCommonConstant.LING_WU_CODE, qiTaLingWuCount + 1);
            } else if (XiuXingCommonConstant.ZHEN_FA.equals(funcModelCode)) {
                int zhenFaCount = zhenFaService.getZhenFaCount();
                request.put(XiuXingCommonConstant.ZHEN_FA_CODE, zhenFaCount + 1);
            } else if (XiuXingCommonConstant.YAO_SHOU.equals(funcModelCode)) {
                int yaoShouCount = yaoShouService.getYaoShouCount();
                request.put(XiuXingCommonConstant.YAO_SHOU_CODE, yaoShouCount + 1);
            } else if (XiuXingCommonConstant.LING_QI.equals(funcModelCode)) {
                int lingQiCount = lingQiService.getLingQiCount();
                request.put(XiuXingCommonConstant.LING_QI_CODE, lingQiCount + 1);
            } else if (XiuXingCommonConstant.LING_DAN.equals(funcModelCode)) {
                int lingDanCount = lingDanService.getLingDanCount();
                request.put(XiuXingCommonConstant.LING_DAN_CODE, lingDanCount + 1);
            } else if (XiuXingCommonConstant.LING_CAI.equals(funcModelCode)) {
                int lingCaiCount = lingCaiService.getLingCaiCount();
                request.put(XiuXingCommonConstant.LING_CAI_CODE, lingCaiCount + 1);
            } else if (XiuXingCommonConstant.KUI_LEI.equals(funcModelCode)) {
                int kuiLeiCount = kuiLeiService.getKuiLeiCount();
                request.put(XiuXingCommonConstant.KUI_LEI_CODE, kuiLeiCount + 1);
            } else if (XiuXingCommonConstant.GONG_FA.equals(funcModelCode)) {
                int gongFaCount = gongFaService.getGongFaCount();
                request.put(XiuXingCommonConstant.GONG_FA_CODE, gongFaCount + 1);
            } else if (XiuXingCommonConstant.FA_SHU.equals(funcModelCode)) {
                int faShuCount = faShuService.getFaShuCount();
                request.put(XiuXingCommonConstant.FA_SHU_CODE, faShuCount + 1);
            } else if (XiuXingCommonConstant.FU_LU.equals(funcModelCode)) {
                int fuLuCount = fuLuService.getFuLuCount();
                request.put(XiuXingCommonConstant.FU_LU_CODE, fuLuCount + 1);
            } else if (XiuXingCommonConstant.SHE_DING.equals(funcModelCode)) {
                int sheDingCount = sheDingService.getSheDingCount();
                request.put(XiuXingCommonConstant.SHE_DING_CODE, sheDingCount + 1);
            } else if (XiuXingCommonConstant.ZONG_MEN.equals(funcModelCode)) {
                int zongMenCount = zongMenService.getZongMenCount();
                request.put(XiuXingCommonConstant.ZONG_MEN_CODE, zongMenCount + 1);
            } else if (XiuXingCommonConstant.JI_GOU.equals(funcModelCode)) {
                int jiGouCount = jiGouService.getJiGouCount();
                request.put(XiuXingCommonConstant.JI_GOU_CODE, jiGouCount + 1);
            } else if (XiuXingCommonConstant.DI_MING.equals(funcModelCode)) {
                int diMingCount = diMingService.getDiMingCount();
                request.put(XiuXingCommonConstant.DI_MING_CODE, diMingCount + 1);
            } else if (XiuXingCommonConstant.LING_WU.equals(funcModelCode)) {
                int lingWuCount = lingWuService.getLingWuCount();
                request.put(XiuXingCommonConstant.LING_WU_CODE, lingWuCount + 1);
            } else if (XiuXingCommonConstant.SUO_SHU.equals(funcModelCode)) {
                int suoShuCount = suoShuService.getSuoShuCount();
                request.put(XiuXingCommonConstant.SUO_SHU_CODE, suoShuCount + 1);
            } else if (XiuXingCommonConstant.XIU_XING_RI_ZHI.equals(funcModelCode)) {
                int xiuXingRiZhiCount = xiuXingRiZhiService.getXiuXingRiZhiCount(null);
                request.put(XiuXingCommonConstant.XIU_XING_CODE, xiuXingRiZhiCount + 1);
                String cangKuId = (String) request.get(XiuXingCommonConstant.CANG_KU_ID);
                Assert.notEmpty(cangKuId, XiuXingErrorCodeDef.CANG_KU_ID_IS_EMPTY);
                int riZhiCode = xiuXingRiZhiService.getXiuXingRiZhiCount(cangKuId);
                request.put(XiuXingCommonConstant.RI_ZHI_CODE, riZhiCode + 1);
            }
        }
        return true;
    }
}
