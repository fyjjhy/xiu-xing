package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.service.AddressService;
import com.hbasesoft.xiu.xing.service.DiMingService;
import com.hbasesoft.xiu.xing.service.FaShuService;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import com.hbasesoft.xiu.xing.service.FuLuService;
import com.hbasesoft.xiu.xing.service.GongFaService;
import com.hbasesoft.xiu.xing.service.HenJiService;
import com.hbasesoft.xiu.xing.service.JiGouService;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.KuiLeiService;
import com.hbasesoft.xiu.xing.service.LingCaiService;
import com.hbasesoft.xiu.xing.service.LingDanService;
import com.hbasesoft.xiu.xing.service.LingQiService;
import com.hbasesoft.xiu.xing.service.LingWuService;
import com.hbasesoft.xiu.xing.service.PinJiService;
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
    private PinJiService pinJiService;

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

    @Resource
    private AddressService addressService;

    @Resource
    private FenLeiService fenLeiService;

    @Resource
    private HenJiService henJiService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> request = flowBean.getRequest();
        if (request.containsKey(XiuXingCommonConstant.FUNC_MODEL_CODE)) {
            String funcModelCode = (String) request.get(XiuXingCommonConstant.FUNC_MODEL_CODE);
            switch (funcModelCode) {
                case XiuXingCommonConstant.REN_WU:
                    int renWuCount = renWuService.getRenWuCount();
                    request.put(XiuXingCommonConstant.REN_WU_CODE, renWuCount + 1);
                    break;
                case XiuXingCommonConstant.JING_JIE:
                    int jingJieCount = jingJieService.getJingJieCount();
                    request.put(XiuXingCommonConstant.JING_JIE_CODE, jingJieCount + 1);
                    break;
                case XiuXingCommonConstant.QI_TA_LING_WU:
                    int qiTaLingWuCount = qiTaLingWuService.getQiTaLingWuCount();
                    request.put(XiuXingCommonConstant.LING_WU_CODE, qiTaLingWuCount + 1);
                    break;
                case XiuXingCommonConstant.ZHEN_FA:
                    int zhenFaCount = zhenFaService.getZhenFaCount();
                    request.put(XiuXingCommonConstant.ZHEN_FA_CODE, zhenFaCount + 1);
                    break;
                case XiuXingCommonConstant.YAO_SHOU:
                    int yaoShouCount = yaoShouService.getYaoShouCount();
                    request.put(XiuXingCommonConstant.YAO_SHOU_CODE, yaoShouCount + 1);
                    break;
                case XiuXingCommonConstant.LING_QI:
                    int lingQiCount = lingQiService.getLingQiCount();
                    request.put(XiuXingCommonConstant.LING_QI_CODE, lingQiCount + 1);
                    break;
                case XiuXingCommonConstant.LING_DAN:
                    int lingDanCount = lingDanService.getLingDanCount();
                    request.put(XiuXingCommonConstant.LING_DAN_CODE, lingDanCount + 1);
                    break;
                case XiuXingCommonConstant.LING_CAI:
                    int lingCaiCount = lingCaiService.getLingCaiCount();
                    request.put(XiuXingCommonConstant.LING_CAI_CODE, lingCaiCount + 1);
                    break;
                case XiuXingCommonConstant.KUI_LEI:
                    int kuiLeiCount = kuiLeiService.getKuiLeiCount();
                    request.put(XiuXingCommonConstant.KUI_LEI_CODE, kuiLeiCount + 1);
                    break;
                case XiuXingCommonConstant.GONG_FA:
                    int gongFaCount = gongFaService.getGongFaCount();
                    request.put(XiuXingCommonConstant.GONG_FA_CODE, gongFaCount + 1);
                    break;
                case XiuXingCommonConstant.FA_SHU:
                    int faShuCount = faShuService.getFaShuCount();
                    request.put(XiuXingCommonConstant.FA_SHU_CODE, faShuCount + 1);
                    break;
                case XiuXingCommonConstant.FU_LU:
                    int fuLuCount = fuLuService.getFuLuCount();
                    request.put(XiuXingCommonConstant.FU_LU_CODE, fuLuCount + 1);
                    break;
                case XiuXingCommonConstant.SHE_DING:
                    int sheDingCount = sheDingService.getSheDingCount();
                    request.put(XiuXingCommonConstant.SHE_DING_CODE, sheDingCount + 1);
                    break;
                case XiuXingCommonConstant.ZONG_MEN:
                    int zongMenCount = zongMenService.getZongMenCount();
                    request.put(XiuXingCommonConstant.ZONG_MEN_CODE, zongMenCount + 1);
                    break;
                case XiuXingCommonConstant.JI_GOU:
                    int jiGouCount = jiGouService.getJiGouCount();
                    request.put(XiuXingCommonConstant.JI_GOU_CODE, jiGouCount + 1);
                    break;
                case XiuXingCommonConstant.DI_MING:
                    int diMingCount = diMingService.getDiMingCount();
                    request.put(XiuXingCommonConstant.DI_MING_CODE, diMingCount + 1);
                    break;
                case XiuXingCommonConstant.LING_WU:
                    int lingWuCount = lingWuService.getLingWuCount();
                    request.put(XiuXingCommonConstant.LING_WU_CODE, String.valueOf(lingWuCount + 1));
                    break;
                case XiuXingCommonConstant.SUO_SHU:
                    int suoShuCount = suoShuService.getSuoShuCount();
                    request.put(XiuXingCommonConstant.SUO_SHU_CODE, String.valueOf(suoShuCount + 1));
                    break;
                case XiuXingCommonConstant.XIU_XING_RI_ZHI:
                    int xiuXingRiZhiCount = xiuXingRiZhiService.getXiuXingRiZhiCount(null);
                    request.put(XiuXingCommonConstant.XIU_XING_CODE, xiuXingRiZhiCount + 1);
                    String cangKuId = (String) request.get(XiuXingCommonConstant.CANG_KU_ID);
                    Assert.notEmpty(cangKuId, XiuXingErrorCodeDef.CANG_KU_ID_IS_EMPTY);
                    int riZhiCode = xiuXingRiZhiService.getXiuXingRiZhiCount(cangKuId);
                    request.put(XiuXingCommonConstant.RI_ZHI_CODE, riZhiCode + 1);
                    break;
                case XiuXingCommonConstant.ADDERSS:
                    int addressCount = addressService.getAddressCount();
                    request.put(XiuXingCommonConstant.ADDR_CODE, addressCount + 1);
                    break;
                case XiuXingCommonConstant.FEN_LEI:
                    int fenLeiCount = fenLeiService.getFenLeiCount();
                    request.put(XiuXingCommonConstant.FEN_LEI_CODE, fenLeiCount + 1);
                    break;
                case XiuXingCommonConstant.PIN_JI:
                    int pinJiCode = pinJiService.getPinJiCount();
                    request.put(XiuXingCommonConstant.PIN_JI_CODE, pinJiCode + 1);
                    break;
                case XiuXingCommonConstant.HEN_JI:
                    int henJiCode = henJiService.getHenJiCount();
                    request.put(XiuXingCommonConstant.HEN_JI_CODE, henJiCode + 1);
            }
        }
        return true;
    }
}
