package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 属历史编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("ShuHisUpdateFilter")
public class ShuHisUpdateFilter implements ServiceFilter {

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        Map<String, Object> shuHisReqMap = flowBean.getRequest();
        JSONObject shuHisJson = new JSONObject(shuHisReqMap);
        ShuHisEntity shuHisEntity =  JSON.toJavaObject(shuHisJson, ShuHisEntity.class);
        // 如果属信息中存在章节ID，则将属信息与章节ID信息保存到zhang_jie_cong_shu
        String zhangJieId = (String) shuHisReqMap.get("zhangJieId");
        if (StringUtils.isNotEmpty(zhangJieId)) {
            // 删除zhang_jie_cong_shu表中的对应章节的空数据
            int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
            LoggerUtil.info("删除章节属空数据：{0}", emptyCount);
            // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
            // 如果存在，则不作任何处理
            // 如果不存在，则添加到zhang_jie_cong_shu表中
            ZhangJieCongShuEntity zhangJieCongShuEntity = new ZhangJieCongShuEntity();
            zhangJieCongShuEntity.setType("属");
            zhangJieCongShuEntity.setCongShuHisId(shuHisEntity.getId());
            zhangJieCongShuEntity.setCongShuId(shuHisEntity.getShuId());
            zhangJieCongShuEntity.setZhangJieId(zhangJieId);
            zhangJieCongShuEntity.setXiaoShuoId(shuHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongShuEntity);
        }
    }
}
