package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.DiMingEntity;
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
public interface DiMingService {

    /**
     * Description: 查询地名列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getDiMingCount();

    /**
     * Description: 获取地名信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param diMingId
     * @return <br>
     */
    @Transactional(readOnly = true)
    DiMingEntity getDiMingById(String diMingId);

    /**
     * Description: 更新地名信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param diMingEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateDiMing(DiMingEntity diMingEntity);

}
