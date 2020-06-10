package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.ServData;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
public interface ServDataService {

    /**
     * Description: 获取服务脚本数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param servId
     * @param action
     * @return <br>
     */
    ServData getServiceDataEntityByServId(String servId, String action);

}
