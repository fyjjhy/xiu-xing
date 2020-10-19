package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.ConfigItemApi;
import com.hbasesoft.xiu.xing.service.ConfigItemService;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ConfigItemController implements ConfigItemApi {

    @Resource
    private ConfigItemService configItemService;

    @Override
    public String config(@PathVariable("funcCode") String funcCode,
                         @PathVariable("configCode") String configCode) {
        return configItemService.getConfigItem(funcCode, configCode);
    }
}
