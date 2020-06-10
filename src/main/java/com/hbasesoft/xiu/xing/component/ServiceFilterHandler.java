package com.hbasesoft.xiu.xing.component;

import java.util.Map;


/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @since V1.0<br>
 * @see <br>
 */
public class ServiceFilterHandler {

    private ServiceFilter serviceFilter;

    private Map<String, Object> configParams;

    /**
     * @param serviceFilter
     * @param configParams
     */
    public ServiceFilterHandler(ServiceFilter serviceFilter, Map<String, Object> configParams) {
        super();
        this.serviceFilter = serviceFilter;
        this.configParams = configParams;
    }

    public ServiceFilter getServiceFilter() {
        return serviceFilter;
    }

    public Map<String, Object> getConfigParams() {
        return configParams;
    }
}
