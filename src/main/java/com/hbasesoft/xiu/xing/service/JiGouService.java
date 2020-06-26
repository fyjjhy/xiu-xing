package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.JiGouEntity;
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
public interface JiGouService {

    /**
     * Description: 查询机构列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getJiGouCount();

    /**
     * Description: 获取机构信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param jiGouId
     * @return <br>
     */
    @Transactional(readOnly = true)
    JiGouEntity getJiGouById(String jiGouId);

    /**
     * Description: 更新机构信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param jiGouEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateJiGou(JiGouEntity jiGouEntity);

}
