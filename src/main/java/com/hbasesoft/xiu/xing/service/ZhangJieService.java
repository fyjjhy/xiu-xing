package com.hbasesoft.xiu.xing.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年10月17日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface ZhangJieService {

    /**
     * Description: 根据小说标识获取小说对应的章节数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param xiaoShuoId
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getZhangJieCount(String xiaoShuoId);
    
}
