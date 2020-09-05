package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> address的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-08-12 <br>
 * @since V1.0<br>
 * @see AddressEntity <br>
 */
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

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

    /** p_id */
    @Column(name = "p_id")
    private String pId;

    /** addr_type */
    @Column(name = "addr_type")
    private String addrType;

    /** addr_code */
    @Column(name = "addr_code")
    private String addrCode;

    /** addr_name */
    @Column(name = "addr_name")
    private String addrName;

    /** full_name */
    @Column(name = "full_name")
    private String fullName;

    /** addr_miao_shu */
    @Column(name = "addr_miao_shu")
    private String addrMiaoShu;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPId() {
        return this.pId;
    }

    public void setPId(String pId) {
        this.pId = pId;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrCode() {
        return this.addrCode;
    }

    public void setAddrCode(String addrCode) {
        this.addrCode = addrCode;
    }

    public String getAddrName() {
        return this.addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddrMiaoShu() {
        return this.addrMiaoShu;
    }

    public void setAddrMiaoShu(String addrMiaoShu) {
        this.addrMiaoShu = addrMiaoShu;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
