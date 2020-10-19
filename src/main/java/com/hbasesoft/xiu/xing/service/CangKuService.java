package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.CangKuEntity;
import org.springframework.transaction.annotation.Transactional;

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
public interface CangKuService {

    /**
     * Description: 获取仓库信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param cangKuId
     * @return <br>
     */
    CangKuEntity getCangKuByCangKuId(String cangKuId);

    /**
     * Description: 更新仓库信息，将源属信息更新成目标属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param origin 源属信息
     * @param target 目标属信息
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCangKuBySuoShuId(String origin, String target);

    /**
     * Description: 更新仓库信息，将源属信息更新成目标属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param origin 源属信息
     * @param target 目标属信息
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCangKuByCongShuId(String origin, String target);

    /**
     * Description: 更新仓库信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisId
     * @param congId
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateCangKuByCongShuHisId(String congHisId, String congId);

}
