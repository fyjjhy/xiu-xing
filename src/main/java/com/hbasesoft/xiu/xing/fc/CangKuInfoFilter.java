package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.util.PagerListVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

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
@Component("CangKuInfoFilter")
public class CangKuInfoFilter implements ServiceFilter {

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction())) {
            PagerListVo<Map<String, Object>> response = (PagerListVo<Map<String, Object>>) flowBean.getResponse();
            if (response != null) {
                List<Map<String, Object>> resultList = response.getDatas();
                if (CollectionUtils.isNotEmpty(resultList)) {
                    for (Map<String, Object> result : resultList) {
                        processCangKuInfo(result);
                    }
                    response.setDatas(resultList);
                    flowBean.setResponse(response);
                }
            }
        } else if (ServiceFlowBean.ACTION_GET.equals(flowBean.getAction())) {
            Map<String, Object> response = (Map<String, Object>) flowBean.getResponse();
            if (MapUtils.isNotEmpty(response)) {
                processCangKuInfo(response);
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
    private void processCangKuInfo(Map<String, Object> result) {
        // 灵物名称
        String lingWuName = (String) result.get(XiuXingCommonConstant.LING_WU_NAME);
        StringBuilder lingWu = new StringBuilder();
        if (StringUtils.isNotEmpty(lingWuName)) {
            // 灵物状态
            String lingWuState = (String) result.get(XiuXingCommonConstant.CANG_KU_LING_WU_STATE);
            if (StringUtils.isNotEmpty(lingWuState)) {
                lingWu.append("[").append(lingWuState).append("]");
            }
            // 灵物数量
            String lingWuShuLiang = (String) result.get(XiuXingCommonConstant.LING_WU_SHU_LIANG);
            if (StringUtils.isNotEmpty(lingWuShuLiang)) {
                lingWu.append(lingWuShuLiang);
            }
            // 单位
            String danWei = (String) result.get(XiuXingCommonConstant.DAN_WEI);
            if (StringUtils.isNotEmpty(danWei)) {
                lingWu.append(danWei);
            }
            // 境界
            String jingJieName = (String) result.get(XiuXingCommonConstant.JING_JIE_NAME);
            if (StringUtils.isNotEmpty(jingJieName) && !XiuXingCommonConstant.WU.equals(jingJieName)) {
                lingWu.append(jingJieName);
            }
            // 品级
            String pinJiName = (String) result.get(XiuXingCommonConstant.PIN_JI_NAME);
            if (StringUtils.isNotEmpty(pinJiName) && !XiuXingCommonConstant.WU.equals(pinJiName)) {
                lingWu.append(pinJiName);
            }
            result.put("lingWuFullName", lingWu.append(lingWuName).toString());
        }
        
        // 所属名称
        String suoShuName = (String) result.get(XiuXingCommonConstant.SUO_SHU_NAME);
        StringBuilder suoShu = new StringBuilder();
        if (StringUtils.isNotEmpty(suoShuName)) {
            // 所属境界
            String suoShuJingJieName = (String) result.get(XiuXingCommonConstant.SUO_SHU_JING_JIE_NAME);
            if (StringUtils.isNotEmpty(suoShuJingJieName) && !XiuXingCommonConstant.WU.equals(suoShuJingJieName)) {
                suoShu.append(suoShuJingJieName);
            }
            // 所属品级
            String suoShuPinJiName = (String) result.get(XiuXingCommonConstant.SUO_SHU_PIN_JI_NAME);
            if (StringUtils.isNotEmpty(suoShuPinJiName) && !XiuXingCommonConstant.WU.equals(suoShuPinJiName)) {
                suoShu.append(suoShuPinJiName);
            }
            result.put("suoShuFullName", suoShu.append(suoShuName).toString());
        }        
    }
}
