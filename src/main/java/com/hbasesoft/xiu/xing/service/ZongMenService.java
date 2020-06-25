package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.ZongMenEntity;
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
public interface ZongMenService {

    /**
     * Description: 查询宗门列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getZongMenCount();

    /**
     * Description: 获取宗门信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zongMenId
     * @return <br>
     */
    @Transactional(readOnly = true)
    ZongMenEntity getZongMenById(String zongMenId);

}
