package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.Serv;
import com.hbasesoft.xiu.xing.entity.ProcessEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
public interface ComponentService {

    /**
     * Description: <br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param action
     * @param data
     * @param resId
     * @param entity
     * @param processEntity
     * @return <br>
     */
    @Transactional(readOnly = true)
    Object perform(String action, Map<String, Object> data, String resId, Serv entity, ProcessEntity processEntity);

}
