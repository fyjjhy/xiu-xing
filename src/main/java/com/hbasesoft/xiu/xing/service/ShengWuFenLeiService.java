package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.util.SelOpt;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月05日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface ShengWuFenLeiService {

    /**
     * Description: 获取生物分类数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getShengWuFenLeiCount();

    /**
     * Description: 获取生物分类列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param leiBie
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<SelOpt> queryShengWuFenLeiList(String leiBie);

}
