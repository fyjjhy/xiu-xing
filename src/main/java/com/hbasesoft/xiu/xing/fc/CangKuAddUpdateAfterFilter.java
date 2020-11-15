package com.hbasesoft.xiu.xing.fc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 仓库新增编辑后置拦截器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuAddUpdateAfterFilter")
public class CangKuAddUpdateAfterFilter implements ServiceFilter {

    @Resource
    private CangKuHisService cangKuHisService;

    @Resource
    private ZhangJieCongShuService zhangJieCongShuService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        Map<String, Object> cangKuReqMap = flowBean.getRequest();
        JSONObject cangKuJson = new JSONObject(cangKuReqMap);
        CangKuHisEntity cangKuHisEntity = JSON.toJavaObject(cangKuJson, CangKuHisEntity.class);
        cangKuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        if (ServiceFlowBean.ACTION_ADD.equals(flowBean.getAction())) {
            String cangKuId = (String) flowBean.getResponse();
            cangKuHisEntity.setCangKuId(cangKuId);
        } else if (ServiceFlowBean.ACTION_UPDATE.equals(flowBean.getAction())) {
            cangKuHisEntity.setCangKuId(cangKuHisEntity.getId());
            cangKuHisEntity.setId(null);
        }
        String cangKuHisId = cangKuHisService.saveOrUpdateCangKuHis(cangKuHisEntity);

        // 如果仓库信息中存在章节ID，则将从信息、属信息与章节ID信息保存到zhang_jie_cong_shu
        String zhangJieId = (String) cangKuReqMap.get("zhangJieId");
        String addrId = (String) cangKuReqMap.get("addrId");

        if (StringUtils.isNotEmpty(zhangJieId)) {
            // 删除zhang_jie_cong_shu表中的对应章节的空数据
            // int emptyCount = zhangJieCongShuService.delEmptyZhangJieCongShu(zhangJieId);
            // LoggerUtil.info("[仓库]删除章节从/属空数据：{0}", emptyCount);
            // 查询zhang_jie_cong_shu中是否已经存在章节从属信息
            // 如果存在，则不作任何处理
            // 如果不存在，则添加到zhang_jie_cong_shu表中
//            JSONObject congHisJson = new JSONObject(cangKuReqMap);
//            CongHisEntity congHisEntity = JSON.toJavaObject(congHisJson, CongHisEntity.class);
            ZhangJieCongShuEntity zhangJieCongEntity = new ZhangJieCongShuEntity();
            zhangJieCongEntity.setType("仓从");
            zhangJieCongEntity.setCongShuHisId(cangKuHisId);
            zhangJieCongEntity.setCongShuId(cangKuHisEntity.getCangKuId());
//            zhangJieCongEntity.setCongShuFenLei(congHisEntity.getCongFenLei());
//            zhangJieCongEntity.setCongShuMiaoShu(congHisEntity.getCongMiaoShu());
//            zhangJieCongEntity.setCongShuName(congHisEntity.getCongName());
//            zhangJieCongEntity.setCongShuJingJie(cangKuHisEntity.getCongJingJieId());
//            zhangJieCongEntity.setCongShuPinJi(cangKuHisEntity.getCongPinJiId());
//            zhangJieCongEntity.setCongShuState(cangKuHisEntity.getCongState());
//            zhangJieCongEntity.setCongShuXiuXing(cangKuHisEntity.getCongXiuXing());
            zhangJieCongEntity.setAddrId(addrId);
            zhangJieCongEntity.setZhangJieId(zhangJieId);
            zhangJieCongEntity.setXiaoShuoId(cangKuHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieCongEntity);

//            JSONObject shuHisJson = new JSONObject(cangKuReqMap);
//            ShuHisEntity shuHisEntity = JSON.toJavaObject(shuHisJson, ShuHisEntity.class);
            ZhangJieCongShuEntity zhangJieShuEntity = new ZhangJieCongShuEntity();
            zhangJieShuEntity.setType("属");
            zhangJieShuEntity.setCongShuHisId(cangKuHisEntity.getShuHisId());
            zhangJieShuEntity.setCongShuId(cangKuHisEntity.getShuId());
//            zhangJieShuEntity.setCongShuFenLei(shuHisEntity.getShuFenLei());
//            zhangJieShuEntity.setCongShuMiaoShu(shuHisEntity.getShuMiaoShu());
//            zhangJieShuEntity.setCongShuName(shuHisEntity.getShuName());
//            zhangJieShuEntity.setCongShuJingJie(shuHisEntity.getShuJingJieId());
//            zhangJieShuEntity.setCongShuPinJi(shuHisEntity.getShuPinJiId());
//            zhangJieShuEntity.setCongShuState(shuHisEntity.getShuState());
//            zhangJieShuEntity.setCongShuXiuXing(shuHisEntity.getShuXiuXing());
            zhangJieShuEntity.setAddrId(addrId);
            zhangJieShuEntity.setZhangJieId(zhangJieId);
            zhangJieShuEntity.setXiaoShuoId(cangKuHisEntity.getXiaoShuoId());
            zhangJieCongShuService.saveZhangJieCongShu(zhangJieShuEntity);
        }
    }
}
