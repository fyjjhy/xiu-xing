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
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface CangKuDao extends IGenericBaseDao {

    @Sql("UPDATE cang_ku SET suo_shu_id = :target WHERE suo_shu_id = :origin")
    int updateCangKuBySuoShuId(@Param("origin") String origin, @Param("target") String target);

    @Sql("UPDATE cang_ku SET shu_id = :target WHERE shu_id = :origin")
    int updateCangKuByCongShuId(@Param("origin") String origin, @Param("target") String target);

    @Sql("UPDATE cang_ku SET cong_id = :congId WHERE cong_his_id = :congHisId")
    int updateCangKuByCongShuHisId(@Param("congHisId") String congHisId, @Param("congId") String congId);

}
