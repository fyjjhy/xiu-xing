package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> cong的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-11 <br>
 * @since V1.0<br>
 * @see CongEntity <br>
 */
@Entity
@Table(name = "cong")
public class CongEntity extends BaseEntity {

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

    /** cong_code */
    @Column(name = "cong_code")
    private String congCode;

    /** cong_name */
    @Column(name = "cong_name")
    private String congName;

    /** cong_fen_lei */
    @Column(name = "cong_fen_lei")
    private String congFenLei;

    /** cong_miao_shu */
    @Column(name = "cong_miao_shu")
    private String congMiaoShu;

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

    public String getCongCode() {
        return this.congCode;
    }

    public void setCongCode(String congCode) {
        this.congCode = congCode;
    }

    public String getCongName() {
        return this.congName;
    }

    public void setCongName(String congName) {
        this.congName = congName;
    }

    public String getCongFenLei() {
        return this.congFenLei;
    }

    public void setCongFenLei(String congFenLei) {
        this.congFenLei = congFenLei;
    }

    public String getCongMiaoShu() {
        return this.congMiaoShu;
    }

    public void setCongMiaoShu(String congMiaoShu) {
        this.congMiaoShu = congMiaoShu;
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
