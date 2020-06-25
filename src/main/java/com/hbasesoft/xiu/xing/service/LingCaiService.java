package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.LingCaiEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月13日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface LingCaiService {

    /**
     * Description: 查询灵材列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getLingCaiCount();

    /**
     * Description: 获取灵材信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingCaiId
     * @return <br>
     */
    @Transactional(readOnly = true)
    LingCaiEntity getLingCaiById(String lingCaiId);

}
