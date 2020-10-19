package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.CongHis;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
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
public interface CongHisService {

    /**
     * Description: 保存或修改从操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveOrUpdateCongHis(CongHisEntity congHisEntity);

    /**
     * Description: 保存或修改从操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveCongHis(CongHisEntity congHisEntity);

    /**
     * Description: 获取从操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<CongHisEntity> getCongHisList(String congId);

    /**
     * Description: 获取从操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisEntity
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<CongHisEntity> getCongHisList(CongHisEntity congHisEntity);

    /**
     * Description: 获取灵物历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisId
     * @return <br>
     */
    @Transactional(readOnly = true)
    CongHisEntity getCongHis(String congHisId);

    /**
     * Description: 获取从历史信息列表<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisIds
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<CongHis> getCongHisListById(String congHisIds);

    /**
     * Description: 更新从历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCongHisById(CongHisEntity congHisEntity);

}
