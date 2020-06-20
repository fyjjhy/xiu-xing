package com.hbasesoft.xiu.xing.dao;

import com.hbasesoft.framework.db.Dao;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface RenWuDao extends IGenericBaseDao {

    @Sql("SELECT COUNT(1) FROM ren_wu")
    int getRenWuCount();

    @Sql("SELECT COUNT(1) FROM ren_wu_his where 1=1 #if($lingWuId) and ling_wu_id = :lingWuId #end")
    int getRenWuHisCount(@Param("lingWuId") String lingWuId);

}
