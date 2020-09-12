package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> meta_model_column的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-09-06 <br>
 * @since V1.0<br>
 * @see MetaModelColumnEntity <br>
 */
@Entity
@Table(name = "meta_model_column")
public class MetaModelColumnEntity extends BaseEntity {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** ID */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
    private String id;

    /** model_id */
    @Column(name = "model_id")
    private String modelId;

    /** column_name */
    @Column(name = "column_name")
    private String columnName;

    /** column_code */
    @Column(name = "column_code")
    private String columnCode;

    /** value_type */
    @Column(name = "value_type")
    private String valueType;

    /** default_value */
    @Column(name = "default_value")
    private String defaultValue;

    /** modify_flag */
    @Column(name = "modify_flag")
    private String modifyFlag;

    /** display_type */
    @Column(name = "display_type")
    private String displayType;

    /** comments */
    @Column(name = "comments")
    private String comments;

    /** error_text */
    @Column(name = "error_text")
    private String errorText;

    /** validate_rule */
    @Column(name = "validate_rule")
    private String validateRule;

    /** value_list */
    @Column(name = "value_list")
    private String valueList;

    /** seq */
    @Column(name = "seq")
    private Integer seq;

    /** required_flag */
    @Column(name = "required_flag")
    private String requiredFlag;

    /** search_flag */
    @Column(name = "search_flag")
    private String searchFlag;

    /** profile_display_flag */
    @Column(name = "profile_display_flag")
    private String profileDisplayFlag;

    /** column_width */
    @Column(name = "column_width")
    private String columnWidth;

    /** add_table */
    @Column(name = "add_table")
    private String addTable;

    /** edit_display_flag */
    @Column(name = "edit_display_flag")
    private String editDisplayFlag;

    /** editable */
    @Column(name = "editable")
    private String editable;

    /** list_display_flag */
    @Column(name = "list_display_flag")
    private String listDisplayFlag;

    /** export_display_flag */
    @Column(name = "export_display_flag")
    private String exportDisplayFlag;

    /** sortable */
    @Column(name = "sortable")
    private String sortable;

    /** title_flag */
    @Column(name = "title_flag")
    private String titleFlag;

    /** render_list */
    @Column(name = "render_list")
    private String renderList;

    /** render_profile */
    @Column(name = "render_profile")
    private String renderProfile;

    /** render_edit */
    @Column(name = "render_edit")
    private String renderEdit;

    /** primary_flag */
    @Column(name = "primary_flag")
    private String primaryFlag;

    /** feign_flag */
    @Column(name = "feign_flag")
    private String feignFlag;

    /** state */
    @Column(name = "state")
    private String state;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return this.modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnCode() {
        return this.columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getValueType() {
        return this.valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getModifyFlag() {
        return this.modifyFlag;
    }

    public void setModifyFlag(String modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getValidateRule() {
        return this.validateRule;
    }

    public void setValidateRule(String validateRule) {
        this.validateRule = validateRule;
    }

    public String getValueList() {
        return this.valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getRequiredFlag() {
        return this.requiredFlag;
    }

    public void setRequiredFlag(String requiredFlag) {
        this.requiredFlag = requiredFlag;
    }

    public String getSearchFlag() {
        return this.searchFlag;
    }

    public void setSearchFlag(String searchFlag) {
        this.searchFlag = searchFlag;
    }

    public String getProfileDisplayFlag() {
        return this.profileDisplayFlag;
    }

    public void setProfileDisplayFlag(String profileDisplayFlag) {
        this.profileDisplayFlag = profileDisplayFlag;
    }

    public String getColumnWidth() {
        return this.columnWidth;
    }

    public void setColumnWidth(String columnWidth) {
        this.columnWidth = columnWidth;
    }

    public String getAddTable() {
        return this.addTable;
    }

    public void setAddTable(String addTable) {
        this.addTable = addTable;
    }

    public String getEditDisplayFlag() {
        return this.editDisplayFlag;
    }

    public void setEditDisplayFlag(String editDisplayFlag) {
        this.editDisplayFlag = editDisplayFlag;
    }

    public String getEditable() {
        return this.editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getListDisplayFlag() {
        return this.listDisplayFlag;
    }

    public void setListDisplayFlag(String listDisplayFlag) {
        this.listDisplayFlag = listDisplayFlag;
    }

    public String getExportDisplayFlag() {
        return this.exportDisplayFlag;
    }

    public void setExportDisplayFlag(String exportDisplayFlag) {
        this.exportDisplayFlag = exportDisplayFlag;
    }

    public String getSortable() {
        return this.sortable;
    }

    public void setSortable(String sortable) {
        this.sortable = sortable;
    }

    public String getTitleFlag() {
        return this.titleFlag;
    }

    public void setTitleFlag(String titleFlag) {
        this.titleFlag = titleFlag;
    }

    public String getRenderList() {
        return this.renderList;
    }

    public void setRenderList(String renderList) {
        this.renderList = renderList;
    }

    public String getRenderProfile() {
        return this.renderProfile;
    }

    public void setRenderProfile(String renderProfile) {
        this.renderProfile = renderProfile;
    }

    public String getRenderEdit() {
        return this.renderEdit;
    }

    public void setRenderEdit(String renderEdit) {
        this.renderEdit = renderEdit;
    }

    public String getPrimaryFlag() {
        return this.primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    public String getFeignFlag() {
        return this.feignFlag;
    }

    public void setFeignFlag(String feignFlag) {
        this.feignFlag = feignFlag;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
