package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.Datasource;

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
public interface DatasourceService {

    /**
     * Description: 查询数据源<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param datasourceId
     * @return <br>
     */
    Datasource getDatasourceEntityById(String datasourceId);

}
