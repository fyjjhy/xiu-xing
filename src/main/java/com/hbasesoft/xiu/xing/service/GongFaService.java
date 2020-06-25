package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.GongFaEntity;
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
public interface GongFaService {

    /**
     * Description: 查询功法列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getGongFaCount();

    /**
     * Description: 获取功法信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param gongFaId
     * @return <br>
     */
    @Transactional(readOnly = true)
    GongFaEntity getGongFaById(String gongFaId);

}
