package com.hbasesoft.xiu.xing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/configItem")
public interface ConfigItemApi {

    /**
     * Description: 根据功能ID和配置项代码查询<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param funcCode
     * @param configCode
     * @return <br>
     */
    @GetMapping(value = "/{funcCode}/{configCode}", produces = "text/html;charset=UTF-8")
    String config(@PathVariable("funcCode") String funcCode,
                  @PathVariable("configCode") String configCode);

}
