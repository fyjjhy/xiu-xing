package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.Cong;
import com.hbasesoft.xiu.xing.entity.CongEntity;
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
public interface CongService {

    /**
     * Description: 获取灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param cong
     * @return <br>
     */
    @Transactional(readOnly = true)
    CongEntity getCongByInfo(Cong cong);

    /**
     * Description: 更新灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateCong(CongEntity congEntity);

    /**
     * Description: 保存灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveCong(CongEntity congEntity);

    /**
     * Description: 获取灵物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congId
     * @return <br>
     */
    @Transactional(readOnly = true)
    CongEntity getCongById(String congId);

    /**
     * Description: 获取从数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getCongCount();

}
