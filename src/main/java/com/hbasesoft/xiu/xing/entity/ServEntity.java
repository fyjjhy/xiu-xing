package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> serv的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-27 <br>
 * @since V1.0<br>
 * @see ServEntity <br>
 */
@Entity
@Table(name = "serv")
public class ServEntity extends BaseEntity {

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

    /** serv_code */
    @Column(name = "serv_code")
    private String servCode;

    /** category */
    @Column(name = "category")
    private String category;

    /** serv_name */
    @Column(name = "serv_name")
    private String servName;

    /** state */
    @Column(name = "state")
    private String state;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServCode() {
        return this.servCode;
    }

    public void setServCode(String servCode) {
        this.servCode = servCode;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getServName() {
        return this.servName;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

}
