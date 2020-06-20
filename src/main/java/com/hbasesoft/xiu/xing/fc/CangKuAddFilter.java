package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.RenWu;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.entity.RenWuEntity;
import com.hbasesoft.xiu.xing.entity.RenWuHisEntity;
import com.hbasesoft.xiu.xing.service.RenWuService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月20日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("CangKuAddFilter")
public class CangKuAddFilter implements ServiceFilter {

    @Resource
    private RenWuService renWuService;

    @Override
    public boolean before(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams) {
        Map<String, Object> cangKuRequest = flowBean.getRequest();
        if (MapUtils.isNotEmpty(cangKuRequest)) {
            String lingWuFenLei = (String) cangKuRequest.get("lingWuFenLei");
            String lingWuName = (String) cangKuRequest.get("lingWuName");
            String lingWuShuXing = (String) cangKuRequest.get("lingWuShuXing");
            String lingWuMiaoShu = (String) cangKuRequest.get("lingWuMiaoShu");
            String lingWuState = (String) cangKuRequest.get("lingWuState");
            String xiaoShuoId = (String) cangKuRequest.get("xiaoShuoId");
            String lingWuId = (String) cangKuRequest.get("lingWuId");
            RenWu renWu = new RenWu();
            renWu.setRenWuFenLei(lingWuFenLei);
            renWu.setRenWuName(lingWuName);
            renWu.setRenWuShuXing(lingWuShuXing);
            renWu.setRenWuMiaoShu(lingWuMiaoShu);
            renWu.setRenWuState(lingWuState);
            renWu.setXiaoShuoId(xiaoShuoId);
            if (StringUtils.isEmpty(lingWuId)) {
                RenWuEntity renWuEntity = renWuService.saveOrUpdate(renWu);
                cangKuRequest.put("lingWuId", renWuEntity.getId());
            } else {
                RenWuEntity renWuEntity = renWuService.getRenWuById(lingWuId);
                renWu.setId(lingWuId);
                renWu.setRenWuCode(renWuEntity.getRenWuCode());
                if (!renWu.equals(renWuEntity)) {
                    // 先处理人物历史表
                    RenWuHisEntity renWuHisEntity = new RenWuHisEntity();
                    BeanUtils.copyProperties(renWuEntity, renWuHisEntity);
                    int renWuHisCount = renWuService.getRenWuHisCount(lingWuId);
                    renWuHisEntity.setRenWuHisCode(String.valueOf(++renWuHisCount));
                    renWuService.saveRenWuHis(renWuHisEntity);
                }
            }
        }
        return true;
    }
}
