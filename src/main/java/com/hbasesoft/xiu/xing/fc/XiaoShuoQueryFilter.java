package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import com.hbasesoft.xiu.xing.service.XiaoShuoService;
import com.hbasesoft.xiu.xing.util.GlobalConstants;
import com.hbasesoft.xiu.xing.util.PagerListVo;
import org.apache.commons.collections.CollectionUtils;
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
 * @CreateDate 2020年12月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("XiaoShuoQueryFilter")
public class XiaoShuoQueryFilter implements ServiceFilter {

    @Resource
    private XiaoShuoService xiaoShuoService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        if (ServiceFlowBean.ACTION_QUERY.equals(flowBean.getAction())) {
            XiaoShuoEntity xiaoShuoEntity =  xiaoShuoService.getXiaoShuoOne();
            Map<String, Object> shuHisMap = flowBean.getRequest();
            if (shuHisMap.containsKey(Param.PAGE_INDEX)) {
                PagerListVo<Map<String, Object>> response = (PagerListVo<Map<String, Object>>) flowBean.getResponse();
                if (response != null) {
                    List<Map<String, Object>> resultList = response.getDatas();
                    if (CollectionUtils.isNotEmpty(resultList)) {
                        for (Map<String, Object> result : resultList) {
                            processShuHisInfo(xiaoShuoEntity, result);
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
                        processShuHisInfo(xiaoShuoEntity, result);
                    }
                    flowBean.setResponse(response);
                }
            }
        }
    }

    /**
     * Description: 处理属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param xiaoShuoEntity
     * @param result
     * @return <br>
     */
    private void processShuHisInfo(XiaoShuoEntity xiaoShuoEntity, Map<String, Object> result) {
        if (xiaoShuoEntity != null) {
            String xiaoShuoId = (String) result.get(XiuXingCommonConstant.ID);
            if (StringUtils.equals(xiaoShuoEntity.getId(), xiaoShuoId)) {
                result.put("topping", GlobalConstants.YES);
            }
        }
    }
}
