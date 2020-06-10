package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.Datasource;
import com.hbasesoft.xiu.xing.dao.DatasourceDao;
import com.hbasesoft.xiu.xing.entity.DatasourceEntity;
import com.hbasesoft.xiu.xing.service.DatasourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
@Service
public class DatasourceServiceImpl implements DatasourceService {

    @Resource
    private DatasourceDao datasourceDao;

    @Override
    public Datasource getDatasourceEntityById(String datasourceId) {
        DatasourceEntity entity = datasourceDao.get(DatasourceEntity.class, datasourceId);
        Datasource datasource = null;
        if (entity != null) {
            datasource = new Datasource();
            BeanUtils.copyProperties(entity, datasource);
        }
        return datasource;
    }
}
