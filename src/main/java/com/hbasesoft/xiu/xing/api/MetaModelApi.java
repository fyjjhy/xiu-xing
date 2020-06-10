package com.hbasesoft.xiu.xing.api;

import com.hbasesoft.xiu.xing.bean.FuncMetaData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月28日 <br>
 * @see com.hbasesoft.xiu.xing.api <br>
 * @since V1.0 <br>
 */
@RequestMapping("/metaModel")
public interface MetaModelApi {

    /**
     * Description: 查询功能元数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param funcCode
     * @return <br>
     */
    @GetMapping("/{funcCode}")
    FuncMetaData getMetaModel(@PathVariable("funcCode") String funcCode);

}
