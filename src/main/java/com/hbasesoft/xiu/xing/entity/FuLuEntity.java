package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> fu_lu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-15 <br>
 * @since V1.0<br>
 * @see FuLuEntity <br>
 */
@Entity
@Table(name = "fu_lu")
public class FuLuEntity extends BaseEntity {

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

    /** fu_lu_code */
    @Column(name = "fu_lu_code")
    private String fuLuCode;

    /** fu_lu_name */
    @Column(name = "fu_lu_name")
    private String fuLuName;

    /** fu_lu_miao_shu */
    @Column(name = "fu_lu_miao_shu")
    private String fuLuMiaoShu;

    /** fu_lu_shu_xing */
    @Column(name = "fu_lu_shu_xing")
    private String fuLuShuXing;

    /** fu_lu_fen_lei */
    @Column(name = "fu_lu_fen_lei")
    private String fuLuFenLei;

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

    public String getFuLuCode() {
        return this.fuLuCode;
    }

    public void setFuLuCode(String fuLuCode) {
        this.fuLuCode = fuLuCode;
    }

    public String getFuLuName() {
        return this.fuLuName;
    }

    public void setFuLuName(String fuLuName) {
        this.fuLuName = fuLuName;
    }

    public String getFuLuMiaoShu() {
        return this.fuLuMiaoShu;
    }

    public void setFuLuMiaoShu(String fuLuMiaoShu) {
        this.fuLuMiaoShu = fuLuMiaoShu;
    }

    public String getFuLuShuXing() {
        return this.fuLuShuXing;
    }

    public void setFuLuShuXing(String fuLuShuXing) {
        this.fuLuShuXing = fuLuShuXing;
    }

    public String getFuLuFenLei() {
        return this.fuLuFenLei;
    }

    public void setFuLuFenLei(String fuLuFenLei) {
        this.fuLuFenLei = fuLuFenLei;
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
