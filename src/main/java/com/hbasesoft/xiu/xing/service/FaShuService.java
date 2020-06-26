package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.FaShuEntity;
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
public interface FaShuService {

    /**
     * Description: 查询法术列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getFaShuCount();

    /**
     * Description: 获取法术信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param faShuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    FaShuEntity getFaShuById(String faShuId);

    /**
     * Description: 更新法术信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param faShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateFaShu(FaShuEntity faShuEntity);

}
