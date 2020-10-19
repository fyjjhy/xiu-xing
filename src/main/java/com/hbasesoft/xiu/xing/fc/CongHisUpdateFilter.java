package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 从历史编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CongHisUpdateFilter")
public class CongHisUpdateFilter implements ServiceFilter {

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        Map<String, Object> congHisReqMap = flowBean.getRequest();
        JSONObject congHisJson = new JSONObject(congHisReqMap);
        CongHisEntity congHisEntity =  JSON.toJavaObject(congHisJson, CongHisEntity.class);
        // 如果从信息中存在章节ID，则将从信息与章节ID信息保存到zhang_jie_cong_shu
        String zhangJieId = (String) congHisReqMap.get("zhangJieId");
        if (StringUtils.isNotEmpty(zhangJieId)) {
            // 删除zhang_jie_cong_shu表中的对应章节的空数据
            int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
            LoggerUtil.info("删除章节从空数据：{0}", emptyCount);
            // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
            // 如果存在，则不作任何处理
            // 如果不存在，则添加到zhang_jie_cong_shu表中
            ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
            zhangJieCongShuEntity.setType("从");
            zhangJieCongShuEntity.setCongShuHisId(congHisEntity.getId());
            zhangJieCongShuEntity.setCongShuId(congHisEntity.getCongId());
            zhangJieCongShuEntity.setZhangJieId(zhangJieId);
            zhangJieCongShuEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
        }
    }
}
