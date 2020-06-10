package com.hbasesoft.xiu.xing.api;

import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/renWu")
public interface RenWuApi {

    @GetMapping
    Object queryRenWu();

}
