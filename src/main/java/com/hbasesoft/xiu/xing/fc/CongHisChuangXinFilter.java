package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.CongEntity;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.CangKuService;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.service.CongService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <Description> 从历史创新过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CongHisChuangXinFilter")
public class CongHisChuangXinFilter implements ServiceFilter {

    @Resource
    private CongHisService congHisService;

    @Resource
    private CongService congService;

    @Resource
    private CangKuService cangKuService;

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> chuangXinMap = flowBean.getRequest();
        if (MapUtils.isNotEmpty(chuangXinMap)) {
            JSONObject chuangXinJson = new JSONObject(chuangXinMap);
            CongHisEntity congHisEntity = JSON.toJavaObject(chuangXinJson, CongHisEntity.class);
            LoggerUtil.info("[创新-before] 从历史信息：{0}", congHisEntity);
            // 判断从历史中是否已经存有此信息
            // 如果有（该条记录除外），删除该该条记录，并更新仓库信息，更新章节从属信息
            // 如果没有，创建新从信息，更新该条记录，更新仓库信息，更新章节从属信息
            // 查询从历史信息
            List<CongHisEntity> congHisEntityList = congHisService.getCongHisList(congHisEntity);
            Assert.notEmpty(congHisEntityList, XiuXingErrorCodeDef.CONG_HIS_INFO_IS_EMPTY);
            List<CongHisEntity> congHisEntities = congHisEntityList.stream()
                    .filter(entity -> !entity.getId().equals(congHisEntity.getId()))
                    .collect(Collectors.toList());
            if (CollectionUtils.isEmpty(congHisEntities)) {
                CongEntity congEntity = new CongEntity();
                congEntity.setCongMiaoShu(congHisEntity.getCongMiaoShu());
                congEntity.setCongFenLei(congHisEntity.getCongFenLei());
                congEntity.setCongName(congHisEntity.getCongName());
                // 查询总量
                int congCount = congService.getCongCount();
                congEntity.setCongCode(String.valueOf(++congCount));
                congEntity.setUpdateTime(congHisEntity.getUpdateTime());
                congEntity.setXiaoShuoId(congHisEntity.getXiaoShuoId());
                String congId = congService.saveCong(congEntity);
                congHisEntity.setCongId(congId);
                congHisEntity.setCongCode(congEntity.getCongCode());
                chuangXinMap.put("congId", congId);
                chuangXinMap.put("congCode", congEntity.getCongCode());
                int congHisCount = congHisService.updateCongHisById(congHisEntity);
                LoggerUtil.info("[创新] 更新从历史：{0}", congHisCount);
            }
            else {
                CongHisEntity entity = congHisEntities.get(0);
                chuangXinMap.put("congId", entity.getCongId());
                chuangXinMap.put("congCode", entity.getCongCode());
            }
        }
        return true;
    }

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        // 更新仓库信息
        Map<String, Object> chuangXinMap = flowBean.getRequest();
        if (MapUtils.isNotEmpty(chuangXinMap)) {
            JSONObject chuangXinJson = new JSONObject(chuangXinMap);
            CongHisEntity congHisEntity = JSON.toJavaObject(chuangXinJson, CongHisEntity.class);
            LoggerUtil.info("[创新-after] 从历史信息：{0}", congHisEntity);
            // 更新仓库信息
            int cangKuCount = cangKuService.updateCangKuByCongShuHisId(congHisEntity.getId(), congHisEntity.getCongId());
            LoggerUtil.info("[创建] 更新仓库信息：{0}", cangKuCount);
            // 更新仓库历史信息
            int cangKuHisCount = cangKuHisService.updateCangKuHisByCongShuHisId(congHisEntity.getId(), congHisEntity.getCongId());
            LoggerUtil.info("[创建] 更新仓库历史信息：{0}", cangKuHisCount);
            // 更新章节从属信息
            int zhangJieCongShuCount = zhangJieCongShuService.updateZhangJieCongShuByCongShuHisId(congHisEntity.getId(), congHisEntity.getCongId());
            LoggerUtil.info("[创建] 更新章节从属信息：{0}", zhangJieCongShuCount);
        }
    }
}
