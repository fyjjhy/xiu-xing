package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.FuLuEntity;
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
public interface FuLuService {

    /**
     * Description: 查询符箓列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getFuLuCount();

    /**
     * Description: 获取符箓信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param fuLuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    FuLuEntity getFuLuById(String fuLuId);

    /**
     * Description: 更新符箓信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param fuLuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateFuLu(FuLuEntity fuLuEntity);

}
