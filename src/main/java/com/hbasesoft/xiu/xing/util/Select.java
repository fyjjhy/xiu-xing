package com.hbasesoft.xiu.xing.util;

/**
 * <Description><br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年03月14日 <br>
 * @see  <br>
 * @since V1.0<br>
 **/
public class Select extends AbstractTreeAble {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -3331957381267753238L;

    private String key;

    private String parentKey;

    private String label;

    private String value;

    private String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
