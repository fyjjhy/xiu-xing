package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Getter
@Setter
public class MetaModelAction extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -5532074707801098344L;

    private String id;

    /** model_id */
    private String modelId;

    /** type */
    private String type;

    /** code */
    private String code;

    private String name;

    /** serv_id */
    private String servId;

    /** serv_action */
    private String servAction;

    /** default_flag */
    private String defaultFlag;

    /** disable_rule */
    private String disableRule;

    /** prop_flag */
    private String propFlag;

    private String propMsg;

    private String delErrorMsg;

    private String servCode;

    private String category;

    private String seq;

    private String displayType;

    private String icon;

}
