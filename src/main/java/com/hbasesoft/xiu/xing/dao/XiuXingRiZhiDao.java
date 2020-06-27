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
 * @CreateDate 2020年06月27日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface XiuXingRiZhiDao extends IGenericBaseDao {

    @Sql("select count(1) from xiu_xing_ri_zhi where 1=1 #if($cangKuId) and cang_ku_id = :cangKuId #end")
    int getXiuXingRiZhiCount(@Param("cangKuId") String cangKuId);

}
