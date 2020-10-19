package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.CongShuEntity;
import com.hbasesoft.xiu.xing.entity.CongShuHisEntity;
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
public interface CongShuService {

    /**
     * Description: 获取所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    CongShuEntity getCongShuById(String congShuId);

    /**
     * Description: 更新所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateCongShu(CongShuEntity congShuEntity);

    /**
     * Description: 保存所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveCongShu(CongShuEntity congShuEntity);

    /**
     * Description: 获取所属数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getCongShuCount();

    /**
     * Description: 删除从属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuId
     * @return <br>
     */
    // @Transactional(rollbackFor = Throwable.class)
    void delCongShuById(String congShuId);

    /**
     * Description: 获取从属历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuHisId
     * @return <br>
     */
    @Transactional(readOnly = true)
    CongShuHisEntity getLCongShuHis(String congShuHisId);

}
