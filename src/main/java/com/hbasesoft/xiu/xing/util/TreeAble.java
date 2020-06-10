package com.hbasesoft.xiu.xing.util;

import java.util.List;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年3月26日 <br>
 * @since V1.0<br>
 * @see TreeAble <br>
 */
public interface TreeAble {

    String getKey();

    void setKey(String key);

    String getParentKey();

    void setParentKey(String parentKey);

    String getLabel();

    void setLabel(String label);

    String getValue();

    void setValue(String value);

    List<TreeAble> getChildren();

    void setChildren(List<TreeAble> children);
}
