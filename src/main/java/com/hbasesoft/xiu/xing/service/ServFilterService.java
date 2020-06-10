package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.ServFilterEntity;

import java.util.List;

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
public interface ServFilterService {

    /**
     * Description: 查询服务过滤器表<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param action
     * @return <br>
     */
    List<ServFilterEntity> queryServFilter(String category, String servCode, String action);

}
