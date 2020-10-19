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
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface ZhangJieDao extends IGenericBaseDao {

    @Sql("select count(1) from zhang_jie where #if($xiaoShuoId) xiao_shuo_id=:xiaoShuoId #else xiao_shuo_id is null #end")
    int getZhangJieCount(@Param("xiaoShuoId") String xiaoShuoId);

}
