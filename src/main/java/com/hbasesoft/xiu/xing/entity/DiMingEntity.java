package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> di_ming的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-16 <br>
 * @since V1.0<br>
 * @see DiMingEntity <br>
 */
@Entity
@Table(name = "di_ming")
public class DiMingEntity extends BaseEntity {

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

    /** di_ming_code */
    @Column(name = "di_ming_code")
    private String diMingCode;

    /** di_ming_name */
    @Column(name = "di_ming_name")
    private String diMingName;

    /** di_ming_fen_lei */
    @Column(name = "di_ming_fen_lei")
    private String diMingFenLei;

    /** di_ming_miao_shu */
    @Column(name = "di_ming_miao_shu")
    private String diMingMiaoShu;

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

    public String getDiMingCode() {
        return this.diMingCode;
    }

    public void setDiMingCode(String diMingCode) {
        this.diMingCode = diMingCode;
    }

    public String getDiMingName() {
        return this.diMingName;
    }

    public void setDiMingName(String diMingName) {
        this.diMingName = diMingName;
    }

    public String getDiMingFenLei() {
        return this.diMingFenLei;
    }

    public void setDiMingFenLei(String diMingFenLei) {
        this.diMingFenLei = diMingFenLei;
    }

    public String getDiMingMiaoShu() {
        return this.diMingMiaoShu;
    }

    public void setDiMingMiaoShu(String diMingMiaoShu) {
        this.diMingMiaoShu = diMingMiaoShu;
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
