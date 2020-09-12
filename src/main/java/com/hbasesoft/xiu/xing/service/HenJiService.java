package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年09月06日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface HenJiService {

    /**
     * Description: 查询痕迹列表总量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getHenJiCount();

    /**
     * Description: 获取痕迹信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param henJiId
     * @return <br>
     */
    @Transactional(readOnly = true)
    HenJiEntity getHenJi(String henJiId);

    /**
     * Description: 保存痕迹信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param henJiEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    String saveHenJi(HenJiEntity henJiEntity);

}
