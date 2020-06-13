package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.service.JingJieService;
import com.hbasesoft.xiu.xing.service.QiTaLingWuService;
import com.hbasesoft.xiu.xing.service.RenWuService;
import com.hbasesoft.xiu.xing.service.YaoShouService;
import com.hbasesoft.xiu.xing.service.ZhenFaService;
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
            }
        }
        return true;
    }
}
