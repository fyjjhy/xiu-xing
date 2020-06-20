package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.bean.RenWu;
import com.hbasesoft.xiu.xing.entity.RenWuEntity;
import com.hbasesoft.xiu.xing.entity.RenWuHisEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface RenWuService {

    @Transactional(readOnly = true)
    Object queryRenWu();

    /**
     * Description: 查询人物列表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getRenWuCount();

    /**
     * Description: 查询人物历史表总数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getRenWuHisCount(String lingWuId);

    /**
     * Description: 保存或更新人物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param renWu
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    RenWuEntity saveOrUpdate(RenWu renWu);

    /**
     * Description: 获取人物信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param lingWuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    RenWuEntity getRenWuById(String lingWuId);

    /**
     * Description: 保存人物历史数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param hisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void saveRenWuHis(RenWuHisEntity hisEntity);

}
