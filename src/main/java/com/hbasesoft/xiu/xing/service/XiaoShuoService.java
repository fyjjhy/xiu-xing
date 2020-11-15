package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月07日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface XiaoShuoService {

    /**
     * Description: 获取小说信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param xiaoShuoId
     * @return <br>
     */
    @Transactional(readOnly = true)
    XiaoShuoEntity getXiaoShuo(String xiaoShuoId);

}
