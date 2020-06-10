package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> serv_filter的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-27 <br>
 * @since V1.0<br>
 * @see ServFilterEntity <br>
 */
@Entity
@Table(name = "serv_filter")
public class ServFilterEntity extends BaseEntity {

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

    /** filter_code */
    @Column(name = "filter_code")
    private String filterCode;

    /** filter_name */
    @Column(name = "filter_name")
    private String filterName;

    /** filter_instance */
    @Column(name = "filter_instance")
    private String filterInstance;

    /** seq */
    @Column(name = "seq")
    private Integer seq;

    /** serv_codes */
    @Column(name = "serv_codes")
    private String servCodes;

    /** serv_actions */
    @Column(name = "serv_actions")
    private String servActions;

    /** config_params */
    @Column(name = "config_params")
    private String configParams;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilterCode() {
        return this.filterCode;
    }

    public void setFilterCode(String filterCode) {
        this.filterCode = filterCode;
    }

    public String getFilterName() {
        return this.filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterInstance() {
        return this.filterInstance;
    }

    public void setFilterInstance(String filterInstance) {
        this.filterInstance = filterInstance;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getServCodes() {
        return this.servCodes;
    }

    public void setServCodes(String servCodes) {
        this.servCodes = servCodes;
    }

    public String getServActions() {
        return this.servActions;
    }

    public void setServActions(String servActions) {
        this.servActions = servActions;
    }

    public String getConfigParams() {
        return this.configParams;
    }

    public void setConfigParams(String configParams) {
        this.configParams = configParams;
    }

}
