/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
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
 * @see <br>
 */
public class AbstractTreeAble extends AbstractVo implements TreeAble {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 8147947576495505972L;

    private String key;

    private String parentKey;

    private String label;

    private String value;

    private List<TreeAble> children;

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

    public List<TreeAble> getChildren() {
        return children;
    }

    public void setChildren(List<TreeAble> children) {
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
