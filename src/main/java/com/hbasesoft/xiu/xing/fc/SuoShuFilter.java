package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.DiMingEntity;
import com.hbasesoft.xiu.xing.entity.JiGouEntity;
import com.hbasesoft.xiu.xing.entity.ZongMenEntity;
import com.hbasesoft.xiu.xing.service.DiMingService;
import com.hbasesoft.xiu.xing.service.JiGouService;
import com.hbasesoft.xiu.xing.service.ZongMenService;
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
@Deprecated
@Component("SuoShuFilter")
public class SuoShuFilter implements ServiceFilter {

    @Resource
    private ZongMenService zongMenService;

    @Resource
    private JiGouService jiGouService;

    @Resource
    private DiMingService diMingService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction())) {
            PagerListVo<Map<String, Object>> response = (PagerListVo<Map<String, Object>>) flowBean.getResponse();
            if (response != null) {
                List<Map<String, Object>> resultList = response.getDatas();
                if (CollectionUtils.isNotEmpty(resultList)) {
                    for (Map<String, Object> result : resultList) {
                        processSuoShuFenLei(result);
                    }
                    response.setDatas(resultList);
                    flowBean.setResponse(response);
                }
            }
        } else if (ServiceFlowBean.ACTION_GET.equals(flowBean.getAction())) {
            Map<String, Object> response = (Map<String, Object>) flowBean.getResponse();
            if (MapUtils.isNotEmpty(response)) {
                processSuoShuFenLei(response);
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
    private void processSuoShuFenLei(Map<String, Object> result) {
        String suoShuFenLei = (String) result.get(XiuXingCommonConstant.SUO_SHU_FEN_LEI);
        String suoShuId = (String) result.get(XiuXingCommonConstant.SUO_SHU_ID);
        if (StringUtils.isNotEmpty(suoShuFenLei)) {
            switch (suoShuFenLei) {
                case XiuXingCommonConstant.ZONG_MEN:
                case XiuXingCommonConstant.JIA_ZU:
                case XiuXingCommonConstant.ZU_ZHI:
                    ZongMenEntity zongMen = zongMenService.getZongMenById(suoShuId);
                    Assert.notNull(zongMen, XiuXingErrorCodeDef.ZONG_MEN_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.SUO_SHU_CODE, zongMen.getZongMenCode());
                    result.put(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, zongMen.getZongMenMiaoShu());
                    break;
                case XiuXingCommonConstant.DI_MING:
                    DiMingEntity diMing = diMingService.getDiMingById(suoShuId);
                    Assert.notNull(diMing, XiuXingErrorCodeDef.DI_MING_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.SUO_SHU_CODE, diMing.getDiMingCode());
                    result.put(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, diMing.getDiMingMiaoShu());
                    break;
                case XiuXingCommonConstant.JI_GOU:
                    JiGouEntity jiGou = jiGouService.getJiGouById(suoShuId);
                    Assert.notNull(jiGou, XiuXingErrorCodeDef.JI_GOU_INFO_IS_EMPTY);
                    result.put(XiuXingCommonConstant.SUO_SHU_CODE, jiGou.getJiGouCode());
                    result.put(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, jiGou.getJiGouMiaoShu());
                    break;
            }
        }
    }
}
