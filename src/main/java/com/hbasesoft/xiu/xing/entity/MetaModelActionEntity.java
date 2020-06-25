package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> meta_model_action的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see MetaModelActionEntity <br>
 */
@Entity
@Table(name = "meta_model_action")
public class MetaModelActionEntity extends BaseEntity {

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

    /** type */
    @Column(name = "type")
    private String type;

    /** code */
    @Column(name = "code")
    private String code;

    /** serv_id */
    @Column(name = "serv_id")
    private String servId;

    /** serv_action */
    @Column(name = "serv_action")
    private String servAction;

    /** default_flag */
    @Column(name = "default_flag")
    private String defaultFlag;

    /** disable_rule */
    @Column(name = "disable_rule")
    private String disableRule;

    /** prop_flag */
    @Column(name = "prop_flag")
    private String propFlag;

    /** prop_msg */
    @Column(name = "prop_msg")
    private String propMsg;

    /** del_error_msg */
    @Column(name = "del_error_msg")
    private String delErrorMsg;

    /** seq */
    @Column(name = "seq")
    private Integer seq;

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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getServId() {
        return this.servId;
    }

    public void setServId(String servId) {
        this.servId = servId;
    }

    public String getServAction() {
        return this.servAction;
    }

    public void setServAction(String servAction) {
        this.servAction = servAction;
    }

    public String getDefaultFlag() {
        return this.defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getDisableRule() {
        return this.disableRule;
    }

    public void setDisableRule(String disableRule) {
        this.disableRule = disableRule;
    }

    public String getPropFlag() {
        return this.propFlag;
    }

    public void setPropFlag(String propFlag) {
        this.propFlag = propFlag;
    }

    public String getPropMsg() {
        return this.propMsg;
    }

    public void setPropMsg(String propMsg) {
        this.propMsg = propMsg;
    }

    public String getDelErrorMsg() {
        return this.delErrorMsg;
    }

    public void setDelErrorMsg(String delErrorMsg) {
        this.delErrorMsg = delErrorMsg;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

}
