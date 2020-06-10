package com.hbasesoft.xiu.xing.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface RenWuService {

    @Transactional(readOnly = true)
    Object queryRenWu();

    /**
     * Description: 查询人物列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getRenWuCount();

}
