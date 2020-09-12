package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.SuoShuHisEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface SuoShuHisService {

    /**
     * Description: 保存或修改所属操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuHisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveOrUpdateSuoShuHis(SuoShuHisEntity suoShuHisEntity);

    /**
     * Description: 获取所属操作记录列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<SuoShuHisEntity> getSuoShuHisList(String suoShuId);

}
