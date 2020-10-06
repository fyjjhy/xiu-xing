package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.CangKuEntity;

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

}
