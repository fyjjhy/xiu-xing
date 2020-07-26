package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface CangKuHisService {

    /**
     * Description: 保存或更新仓库操作记录信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param hisEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void saveOrUpdateCangKuHis(CangKuHisEntity hisEntity);

}
