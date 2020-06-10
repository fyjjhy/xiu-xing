package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.FuncEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月28日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface FuncService {

    /**
     * Description: 根据功能CODE查询功能<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param funcCode
     * @return <br>
     */
    @Transactional(readOnly = true)
    FuncEntity getFuncByFuncCode(String funcCode);

}
