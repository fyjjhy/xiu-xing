package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> config_item的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-30 <br>
 * @since V1.0<br>
 * @see ConfigItemEntity <br>
 */
@Entity
@Table(name = "config_item")
public class ConfigItemEntity extends BaseEntity {

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

    /** func_id */
    @Column(name = "func_id")
    private String funcId;

    /** config_name */
    @Column(name = "config_name")
    private String configName;

    /** config_code */
    @Column(name = "config_code")
    private String configCode;

    /** config_value */
    @Column(name = "config_value")
    private String configValue;

    /** config_default */
    @Column(name = "config_default")
    private String configDefault;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuncId() {
        return this.funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getConfigName() {
        return this.configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigCode() {
        return this.configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigValue() {
        return this.configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigDefault() {
        return this.configDefault;
    }

    public void setConfigDefault(String configDefault) {
        this.configDefault = configDefault;
    }

}
