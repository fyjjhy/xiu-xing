package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface PinJiService {

    /**
     * Description: 获取品级信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param pinJiId
     * @return <br>
     */
    @Transactional(readOnly = true)
    PinJiEntity getPinJiById(String pinJiId);

}
