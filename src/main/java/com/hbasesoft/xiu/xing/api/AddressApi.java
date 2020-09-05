package com.hbasesoft.xiu.xing.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/address")
public interface AddressApi {

    /**
     * Description: 查询父级地址列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param addrType
     * @return <br>
     */
    @GetMapping
    Object queryAddress(@RequestParam(name = "addrType", required = false) String addrType);

}
