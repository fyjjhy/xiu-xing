package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.LingWuHisEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface LingWuHisService {

    /**
     * Description: 保存或修改灵物操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveOrUpdateLingWuHis(LingWuHisEntity lingWuHisEntity);

    /**
     * Description: 获取灵物操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<LingWuHisEntity> getLingWuHisList(String lingWuId);

    /**
     * Description: 获取灵物历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuHisId
     * @return <br>
     */
    @Transactional(readOnly = true)
    LingWuHisEntity getLingWuHis(String lingWuHisId);

}
