package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.xiu.xing.api.CommonApi;
import com.hbasesoft.xiu.xing.bean.Serv;
import com.hbasesoft.xiu.xing.bean.ServiceFlowBean;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import com.hbasesoft.xiu.xing.entity.ProcessEntity;
import com.hbasesoft.xiu.xing.service.ComponentService;
import com.hbasesoft.xiu.xing.service.ProcessService;
import com.hbasesoft.xiu.xing.service.ServService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@RestController
public class CommonController implements CommonApi {

    public static final String PLATFORM_SERVICE = "PlatformService";

    @Resource
    private ServService servService;

    @Resource
    private ProcessService processService;

    @Resource
    private ComponentService componentService;

    private Object perform(String category, String servCode, String action, Map<String, Object> data, String resId) {
        Serv entity = servService.getServiceByCategoryAndServCode(category, servCode);
        // 获取服务
        Assert.notNull(entity, XiuXingErrorCodeDef.SERVICE_NOT_FOUND);
        // 获取流程规则
        ProcessEntity processEntity = processService.getProcess(PLATFORM_SERVICE);
        Assert.notNull(processEntity, XiuXingErrorCodeDef.PROCESS_NOT_FOUND);
        return componentService.perform(action, data, resId, entity, processEntity);
    }

    @Override
    public <T> T query(
            @PathVariable("category") String category,
            @PathVariable("servCode") String servCode,
            @RequestParam Map<String, Object> data) {
        return (T) perform(category, servCode, ServiceFlowBean.ACTION_QUERY, data, null);
    }

    @Override
    public <T> T get(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                     @PathVariable("resId") String resId) {
        return (T) perform(category, servCode, ServiceFlowBean.ACTION_GET, null, resId);
    }

    @Override
    public <T> T add(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                     @RequestBody Map<String, Object> data) {
        String resId = (String) perform(category, servCode, ServiceFlowBean.ACTION_ADD, data, null);
        return get(category, servCode, resId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public <T> T update(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                        @PathVariable("resId") String resId, @RequestBody Map<String, Object> data) {
        perform(category, servCode, ServiceFlowBean.ACTION_UPDATE, data, resId);
        return get(category, servCode, resId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public <T> T modify(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                        @PathVariable("resId") String resId, @RequestBody Map<String, Object> data) {
        perform(category, servCode, ServiceFlowBean.ACTION_MODIFY, data, resId);
        return get(category, servCode, resId);
    }

    @Override
    public void delete(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                       @PathVariable("resId") String resId) {
        perform(category, servCode, ServiceFlowBean.ACTION_DELETE, null, resId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T action(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                        @PathVariable("action") String action, @RequestBody Map<String, Object> data) {
        return (T) perform(category, servCode, action, data, null);
    }
}
