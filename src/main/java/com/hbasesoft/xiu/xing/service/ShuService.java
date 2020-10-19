package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.ShuEntity;
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
public interface ShuService {

    /**
     * Description: 获取所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    ShuEntity getShuById(String shuId);

    /**
     * Description: 更新所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateShu(ShuEntity shuEntity);

    /**
     * Description: 保存所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveShu(ShuEntity shuEntity);

    /**
     * Description: 获取所属数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getShuCount();

    /**
     * Description: 删除属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuId
     * @return <br>
     */
    // @Transactional(rollbackFor = Throwable.class)
    void delShuById(String shuId);

}
