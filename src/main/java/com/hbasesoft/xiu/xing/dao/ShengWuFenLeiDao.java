package com.hbasesoft.xiu.xing.dao;

import com.hbasesoft.framework.db.Dao;
import com.hbasesoft.framework.db.core.annotation.Param;
import com.hbasesoft.framework.db.core.annotation.Sql;
import com.hbasesoft.framework.db.hibernate.IGenericBaseDao;
import com.hbasesoft.xiu.xing.util.SelOpt;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月05日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface ShengWuFenLeiDao extends IGenericBaseDao {

    @Sql("select count(1) from sheng_wu_fen_lei")
    int getShengWuFenLeiDao();

    @Sql(bean = SelOpt.class)
    List<SelOpt> queryShengWuFenLeiList(@Param("leiBie") String leiBie);

}
