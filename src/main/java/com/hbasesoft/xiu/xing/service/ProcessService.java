package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.ProcessEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月28日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
public interface ProcessService {

    /**
     * Description: 查询流程规则<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param processCode
     * @return <br>
     */
    @Transactional(readOnly = true)
    ProcessEntity getProcess(String processCode);

}
