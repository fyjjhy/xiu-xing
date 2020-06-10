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
public class MetaModelColumn extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -755527656271965520L;

    /** ID */
    private String id;

    /** model_id */
    private String modelId;

    /** column_name */
    private String columnName;

    /** column_code */
    private String columnCode;

    /** value_type */
    private String valueType;

    /** default_value */
    private String defaultValue;

    /** modify_flag */
    private String modifyFlag;

    /** display_type */
    private String displayType;

    /** comments */
    private String comments;

    /** error_text */
    private String errorText;

    /** validate_rule */
    private String validateRule;

    /** value_list */
    private String valueList;

    /** seq */
    private Integer seq;

    /** required_flag */
    private String requiredFlag;

    /** search_flag */
    private String searchFlag;

    /** profile_display_flag */
    private String profileDisplayFlag;

    private String addTable;

    /** edit_display_flag */
    private String editDisplayFlag;

    /** editable */
    private String editable;

    /** list_display_flag */
    private String listDisplayFlag;

    private String exportDisplayFlag;

    /** sortable */
    private String sortable;

    /** render_list */
    private String renderList;

    /** render_profile */
    private String renderProfile;

    /** render_edit */
    private String renderEdit;

    /** primary_flag */
    private String primaryFlag;

    /** feign_flag */
    private String feignFlag;

    /** column_width */
    private String columnWidth;

    /** title_flag */
    private String titleFlag;

}
