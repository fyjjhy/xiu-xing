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
 * @CreateDate 2020年10月17日 <br>
 * @see com.hbasesoft.xiu.xing.dao <br>
 * @since V1.0 <br>
 */
@Dao
public interface ZhangJieCongShuDao extends IGenericBaseDao {

    /**
     * Description: 根据章节标识删除章节从属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @return <br>
     */
    @Sql("delete from zhang_jie_cong_shu where zhang_jie_id = :zhangJieId")
    int delZhangJieCongShuByZhangJieId(@Param("zhangJieId") String zhangJieId);

    /**
     * Description: 删除章节从属空数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @return <br>
     */
    @Sql("delete from zhang_jie_cong_shu where zhang_jie_id = :zhangJieId and type is null")
    int delEmptyZhangJieCongShu(@Param("zhangJieId") String zhangJieId);

    @Sql("update zhang_jie_cong_shu set cong_shu_id = :congShuId where cong_shu_his_id = :congShuHisId and type = '从'")
    int updateZhangJieCongShuByCongShuHisId(@Param("congShuHisId") String congShuHisId, @Param("congShuId") String congShuId);

}
