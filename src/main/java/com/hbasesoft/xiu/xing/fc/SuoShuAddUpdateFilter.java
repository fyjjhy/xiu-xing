package com.hbasesoft.xiu.xing.fc;

import com.hbasesoft.framework.rule.core.FlowContext;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.component.ServiceFilter;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.entity.SuoShuHisEntity;
import com.hbasesoft.xiu.xing.service.SuoShuHisService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> 所属新增编辑过滤器<br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.fc <br>
 * @since V1.0 <br>
 */
@Component("SuoShuAddUpdateFilter")
public class SuoShuAddUpdateFilter implements ServiceFilter {

    @Resource
    private SuoShuHisService suoShuHisService;

    @Override
    public void after(ServiceFlowBean flowBean, FlowContext flowContext, Map<String, Object> configParams, Exception e) {
        String action =  flowBean.getAction();
        Map<String, Object> suoShuReqMap = flowBean.getRequest();
        String suoShuCode = (String) suoShuReqMap.get(XiuXingCommonConstant.SUO_SHU_CODE);
        String suoShuName = (String) suoShuReqMap.get(XiuXingCommonConstant.SUO_SHU_NAME);
        String suoShuFenLei = (String) suoShuReqMap.get(XiuXingCommonConstant.SUO_SHU_FEN_LEI);
        String suoShuMiaoShu = (String) suoShuReqMap.get(XiuXingCommonConstant.SUO_SHU_MIAO_SHU);
        String xiaoShuoId = (String) suoShuReqMap.get(XiuXingCommonConstant.XIAO_SHUO_ID);
        String addrId = (String) suoShuReqMap.get(XiuXingCommonConstant.ADDR_ID);
        SuoShuHisEntity suoShuHisEntity = new SuoShuHisEntity();
        if (ServiceFlowBean.ACTION_ADD.equals(action)) {
            suoShuHisEntity.setSuoShuId((String) flowBean.getResponse());
        } else {
            suoShuHisEntity.setSuoShuId((String) suoShuReqMap.get(XiuXingCommonConstant.ID));
        }
        suoShuHisEntity.setSuoShuCode(suoShuCode);
        suoShuHisEntity.setSuoShuName(suoShuName);
        suoShuHisEntity.setSuoShuFenLei(suoShuFenLei);
        suoShuHisEntity.setSuoShuMiaoShu(suoShuMiaoShu);
        suoShuHisEntity.setXiaoShuoId(xiaoShuoId);
        suoShuHisEntity.setAddrId(addrId);
        suoShuHisEntity.setUpdateTime(DateUtil.getCurrentDate());
        suoShuHisService.saveOrUpdateSuoShuHis(suoShuHisEntity);
    }
}
