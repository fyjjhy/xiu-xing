package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.ShuHis;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
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
public interface ShuHisService {

    /**
     * Description: 保存或修改属操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveOrUpdateShuHis(ShuHisEntity shuHisEntity);

    /**
     * Description: 保存属操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveShuHis(ShuHisEntity shuHisEntity);

    /**
     * Description: 获取属操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<ShuHisEntity> getShuHisList(String shuId);

    /**
     * Description: 获取属操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuHisEntity
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<ShuHisEntity> getShuHisList(ShuHisEntity shuHisEntity);

    /**
     * Description: 获取属历史信息列表<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param shuHisIds
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<ShuHis> getShuHisListById(String shuHisIds);

}
