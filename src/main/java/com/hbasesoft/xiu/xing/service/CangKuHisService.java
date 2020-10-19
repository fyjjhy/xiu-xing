package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface CangKuHisService {

    /**
     * Description: 保存或更新仓库操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param hisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void saveOrUpdateCangKuHis(CangKuHisEntity hisEntity);

    /**
     * Description: 查询从属者的仓库信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congShuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<CangKuHisEntity> queryCangKuHisByCongShu(String congShuId);

    /**
     * Description: 同步灵物所属历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param xiaoShuoId
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void syncLingWuSuoShuHisId(String xiaoShuoId);

    /**
     * Description: 更新仓库历史信息，将源属信息更新成目标属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param origin
     * @param target
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCangKuHisByCongShuId(String origin, String target);

    /**
     * Description: 更新仓库历史信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisId
     * @param congId
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCangKuHisByCongShuHisId(String congHisId, String congId);

}
