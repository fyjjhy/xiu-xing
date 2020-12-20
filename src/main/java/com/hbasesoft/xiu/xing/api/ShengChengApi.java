package com.hbasesoft.xiu.xing.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/shengCheng")
public interface ShengChengApi {

    /**
     * Description: 生成名称<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param data
     * @return <br>
     */
    @PostMapping("/generate")
    List<String> queryAddress(@RequestBody Map<String, Object> data);

}
