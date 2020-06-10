package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * <Description> meta_model的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-30 <br>
 * @since V1.0<br>
 * @see MetaModelEntity <br>
 */
@Entity
@Table(name = "meta_model")
public class MetaModelEntity extends BaseEntity {

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

    /** model_code */
    @Column(name = "model_code")
    private String modelCode;

    /** model_name */
    @Column(name = "model_name")
    private String modelName;

    /** tree_table_flag */
    @Column(name = "tree_table_flag")
    private String treeTableFlag;

    /** parent_column_code */
    @Column(name = "parent_column_code")
    private String parentColumnCode;

    /** child_column_code */
    @Column(name = "child_column_code")
    private String childColumnCode;

    /** func_model_code */
    @Transient
    private String funcModelCode;

    /** search_flag */
    @Transient
    private String searchFlag;

    /** mult_choose_flag */
    @Transient
    private String multChooseFlag;

    /** title */
    @Transient
    private String title;

    /** master_flag */
    @Transient
    private String masterFlag;

    /** position */
    @Transient
    private String position;

    @Transient
    private String parentModelId;

    @Transient
    private String relationship;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelCode() {
        return this.modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getTreeTableFlag() {
        return this.treeTableFlag;
    }

    public void setTreeTableFlag(String treeTableFlag) {
        this.treeTableFlag = treeTableFlag;
    }

    public String getParentColumnCode() {
        return this.parentColumnCode;
    }

    public void setParentColumnCode(String parentColumnCode) {
        this.parentColumnCode = parentColumnCode;
    }

    public String getChildColumnCode() {
        return this.childColumnCode;
    }

    public void setChildColumnCode(String childColumnCode) {
        this.childColumnCode = childColumnCode;
    }

    @Transient
    public String getFuncModelCode() {
        return funcModelCode;
    }

    public void setFuncModelCode(String funcModelCode) {
        this.funcModelCode = funcModelCode;
    }

    @Transient
    public String getSearchFlag() {
        return searchFlag;
    }

    public void setSearchFlag(String searchFlag) {
        this.searchFlag = searchFlag;
    }

    @Transient
    public String getMultChooseFlag() {
        return multChooseFlag;
    }

    public void setMultChooseFlag(String multChooseFlag) {
        this.multChooseFlag = multChooseFlag;
    }

    @Transient
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Transient
    public String getMasterFlag() {
        return masterFlag;
    }

    public void setMasterFlag(String masterFlag) {
        this.masterFlag = masterFlag;
    }

    @Transient
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Transient
    public String getParentModelId() {
        return parentModelId;
    }

    public void setParentModelId(String parentModelId) {
        this.parentModelId = parentModelId;
    }

    @Transient
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
