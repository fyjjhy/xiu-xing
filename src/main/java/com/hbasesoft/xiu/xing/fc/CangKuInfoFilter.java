package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.db.core.annotation.Param;
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
            Map<String, Object> cangKuMap = flowBean.getRequest();
            if (cangKuMap.containsKey(Param.PAGE_INDEX)) {
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
            }
            else {
                List<Map<String, Object>> response = (List<Map<String, Object>>) flowBean.getResponse();
                if (CollectionUtils.isNotEmpty(response)) {
                    for (Map<String, Object> result : response) {
                        processCangKuInfo(result);
                    }
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
     * Description: 处理属分类信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param result
     * @return <br>
     */
    private void processCangKuInfo(Map<String, Object> result) {
        // 从名称
        String congName = (String) result.get(XiuXingCommonConstant.CONG_NAME);
        StringBuilder lingWu = new StringBuilder();
        if (StringUtils.isNotEmpty(congName)) {
            // 从状态
            String congStateName = (String) result.get(XiuXingCommonConstant.CONG_STATE_NAME);
            if (StringUtils.isNotEmpty(congStateName)) {
                lingWu.append("[").append(congStateName).append("]");
            }
            // 从数量
            String congShuLiang = (String) result.get(XiuXingCommonConstant.CONG_SHU_LIANG);
            if (StringUtils.isNotEmpty(congShuLiang)) {
                lingWu.append(congShuLiang);
            }
            // 单位
            String danWei = (String) result.get(XiuXingCommonConstant.DAN_WEI);
            if (StringUtils.isNotEmpty(danWei)) {
                lingWu.append(danWei);
            }
            // 从境界
            String congJingJieName = (String) result.get(XiuXingCommonConstant.CONG_JING_JIE_NAME);
            if (StringUtils.isNotEmpty(congJingJieName) && !XiuXingCommonConstant.WU.equals(congJingJieName)) {
                lingWu.append(congJingJieName);
            }
            // 从品级
            String congPinJiName = (String) result.get(XiuXingCommonConstant.CONG_PIN_JI_NAME);
            if (StringUtils.isNotEmpty(congPinJiName) && !XiuXingCommonConstant.WU.equals(congPinJiName)) {
                lingWu.append(congPinJiName);
            }
            result.put("congFullName", lingWu.append(congName).toString());
        }
        
        // 属名称
        String shuName = (String) result.get(XiuXingCommonConstant.SHU_NAME);
        StringBuilder suoShu = new StringBuilder();
        if (StringUtils.isNotEmpty(shuName)) {
            // 属境界
            String shuJingJieName = (String) result.get(XiuXingCommonConstant.SHU_JING_JIE_NAME);
            if (StringUtils.isNotEmpty(shuJingJieName) && !XiuXingCommonConstant.WU.equals(shuJingJieName)) {
                suoShu.append(shuJingJieName);
            }
            // 属品级
            String shuPinJiName = (String) result.get(XiuXingCommonConstant.SHU_PIN_JI_NAME);
            if (StringUtils.isNotEmpty(shuPinJiName) && !XiuXingCommonConstant.WU.equals(shuPinJiName)) {
                suoShu.append(shuPinJiName);
            }
            result.put("shuFullName", suoShu.append(shuName).toString());
        }        
    }
}
