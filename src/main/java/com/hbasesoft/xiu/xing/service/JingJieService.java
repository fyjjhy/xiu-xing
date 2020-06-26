package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.JingJieEntity;
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
public interface JingJieService {

    /**
     * Description: 查询境界列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getJingJieCount();

    /**
     * Description: 获取境界信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param jingJieId
     * @return <br>
     */
    @Transactional(readOnly = true)
    JingJieEntity getJingJieById(String jingJieId);

}
