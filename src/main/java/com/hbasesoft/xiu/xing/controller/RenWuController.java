package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.RenWuApi;
import com.hbasesoft.xiu.xing.service.RenWuService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.controller <br>
 * @since V1.0 <br>
 */
@RestController
public class RenWuController implements RenWuApi {

    @Resource
    private RenWuService renWuService;

    @Override
    public Object queryRenWu() {
        return renWuService.queryRenWu();
    }
}
