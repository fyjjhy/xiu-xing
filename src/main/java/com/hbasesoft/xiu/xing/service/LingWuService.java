package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.LingWu;
import com.hbasesoft.xiu.xing.entity.LingWuEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface LingWuService {

    /**
     * Description: 获取灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWu
     * @return <br>
     */
    @Transactional(readOnly = true)
    LingWuEntity getLingWuByInfo(LingWu lingWu);

    /**
     * Description: 更新灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateLingWu(LingWuEntity lingWuEntity);

    /**
     * Description: 保存灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveLingWu(LingWuEntity lingWuEntity);

    /**
     * Description: 获取灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    LingWuEntity getLingWuById(String lingWuId);

    /**
     * Description: 获取灵物数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getLingWuCount();

}
