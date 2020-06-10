package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description> <br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年2月8日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Getter
@Setter
public class MetaModel extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 5722364458024534390L;

    /** ID */
    private String id;

	private String parentModelId;

    private String relationship;

    /** model_name */
    private String modelName;

    private String modelCode;

    /** func_model_code */
    private String funcModelCode;

    /** search_flag */
    private String searchFlag;

    /** mult_choose_flag */
    private String multChooseFlag;

    /** title */
    private String title;

    /** master_flag */
    private String masterFlag;

    /** tree_table_flag */
    private String treeTableFlag;

    /** child_column_code */
    private String childColumnCode;

    /** parent_column_code */
    private String parentColumnCode;

    /** position */
    private String position;

	/** state */
    private String state;

    /** state_time */
    private String stateTime;

    private List<MetaModelColumn> columnList;

    private List<MetaModelAction> actionList;

}
