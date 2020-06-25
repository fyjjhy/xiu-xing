package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.YaoShouEntity;
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
public interface YaoShouService {

    /**
     * Description: 查询妖兽列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getYaoShouCount();

    /**
     * Description: 获取妖兽信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param yaoShouId
     * @return <br>
     */
    @Transactional(readOnly = true)
    YaoShouEntity getYaoShouById(String yaoShouId);

}
