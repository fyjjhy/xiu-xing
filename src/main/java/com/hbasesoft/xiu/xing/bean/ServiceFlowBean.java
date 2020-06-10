package com.hbasesoft.xiu.xing.bean;

import java.util.Map;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @since V1.0<br>
 * @see <br>
 */
public class ServiceFlowBean extends Serv {

    public static final String ACTION_QUERY = "query";

    public static final String ACTION_GET = "get";

    public static final String ACTION_UPDATE = "update";

    public static final String ACTION_MODIFY = "modify";

    public static final String ACTION_DELETE = "delete";

    public static final String ACTION_ADD = "add";

    public static final String TYPE_RULE = "R";

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 2758685645522036138L;

    private String action;

    private Map<String, Object> request;

    private ServData servData;

    private Datasource datasource;

    private Object response;

    private String type;

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public ServData getServData() {
        return servData;
    }

    public void setServData(ServData servData) {
        this.servData = servData;
    }

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
