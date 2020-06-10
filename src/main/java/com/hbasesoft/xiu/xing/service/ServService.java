package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.Serv;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface ServService {

    /**
     * Description: 根据服务分类和服务代码查询服务信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @return <br>
     */
    @Transactional(readOnly = true)
    Serv getServiceByCategoryAndServCode(String category, String servCode);

}
