package com.hbasesoft.xiu.xing.dao;

import com.hbasesoft.framework.db.Dao;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface CangKuHisDao extends IGenericBaseDao {

    @Sql(bean = CangKuHisEntity.class)
    List<CangKuHisEntity> queryCangKuHisByCongShu(@Param("congShuId") String congShuId);

    @Sql("UPDATE cang_ku_his SET shu_id = :target WHERE shu_id = :origin")
    int updateCangKuHisByCongShuId(@Param("origin") String origin, @Param("target") String target);

    @Sql("UPDATE cang_ku_his SET cong_id = :congId WHERE cong_his_id = :congHisId")
    int updateCangKuHisByCongShuHisId(@Param("congHisId") String congHisId, @Param("congId") String congId);

}
