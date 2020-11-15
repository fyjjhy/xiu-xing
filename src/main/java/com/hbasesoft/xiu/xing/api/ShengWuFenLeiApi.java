package com.hbasesoft.xiu.xing.api;

import com.hbasesoft.xiu.xing.util.SelOpt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.api <br>
 * @since V1.0 <br>
 */
@RequestMapping("/shengWuFenLei")
public interface ShengWuFenLeiApi {

    /**
     * Description: 根据分类查询生物分类列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param leiBie
     * @return <br>
     */
    @GetMapping("/fenLei")
    List<SelOpt> queryShengWuFenLeiList(@RequestParam("leiBie") String leiBie);

}
