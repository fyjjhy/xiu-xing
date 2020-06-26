package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.QiTaLingWuEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月13日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface QiTaLingWuService {

    /**
     * Description: 查询其他灵物列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getQiTaLingWuCount();

    /**
     * Description: 获取其他灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param qiTaLingWuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    QiTaLingWuEntity getQiTaLingWuById(String qiTaLingWuId);

    /**
     * Description: 更新其他灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param qiTaLingWuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateQiTaLingWu(QiTaLingWuEntity qiTaLingWuEntity);

}
