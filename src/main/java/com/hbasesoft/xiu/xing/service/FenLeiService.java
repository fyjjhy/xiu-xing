package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月05日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface FenLeiService {

    /**
     * Description: 获取分类数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getFenLeiCount();

    /**
     * Description: 获取分类信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param fenLeiId
     * @return <br>
     */
    @Transactional(readOnly = true)
    FenLeiEntity getFenLei(String fenLeiId);

}
