package com.hbasesoft.xiu.xing.api;

import com.hbasesoft.xiu.xing.bean.CangKuHis;
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
@RequestMapping("/cangKuHis")
public interface CangKuHisApi {

    /**
     * Description: 查询所属者的仓库信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param suoShuId
     * @return <br>
     */
    @GetMapping("/minLingWuList")
    List<CangKuHis> queryCangKuHisBySuoShu(@RequestParam("suoShuId") String suoShuId);

}
