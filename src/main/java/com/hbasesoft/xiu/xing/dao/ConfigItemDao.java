package com.hbasesoft.xiu.xing.dao;

import com.hbasesoft.framework.db.Dao;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;
import com.hbasesoft.xiu.xing.entity.ConfigItemEntity;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface ConfigItemDao extends IGenericBaseDao {

    /**
     * Description: 查询配置项<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param funcCode
     * @param configCode
     * @return <br>
     */
    @Sql(bean = ConfigItemEntity.class)
    ConfigItemEntity getConfigItem(@Param("funcCode") String funcCode,
                                   @Param("configCode") String configCode);

}
