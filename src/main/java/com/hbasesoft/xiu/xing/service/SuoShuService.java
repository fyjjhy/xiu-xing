package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.SuoShuEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface SuoShuService {

    /**
     * Description: 获取所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    SuoShuEntity getSuoShuById(String suoShuId);

    /**
     * Description: 更新所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void updateSuoShu(SuoShuEntity suoShuEntity);

    /**
     * Description: 保存所属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveSuoShu(SuoShuEntity suoShuEntity);

    /**
     * Description: 获取所属数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getSuoShuCount();

}
