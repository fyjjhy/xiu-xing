package com.hbasesoft.xiu.xing.dao;

import com.hbasesoft.framework.db.Dao;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;
import com.hbasesoft.xiu.xing.entity.MetaModelEntity;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月29日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface MetaModelDao extends IGenericBaseDao {

    @Sql(bean = MetaModelEntity.class)
    List<MetaModelEntity> queryMetaModelByFuncId(@Param("funcId") String funcId);

}
