package com.hbasesoft.xiu.xing.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月21日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface ZiDianService {

    /**
     * Description: 获取字典收录字数<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getZiDianCount();

    /**
     * Description: 查询字典列表<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param ziDianIds
     * @param ziJiList
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<String> getZiDianList(List<String> ziDianIds, List<String> ziJiList);

}
