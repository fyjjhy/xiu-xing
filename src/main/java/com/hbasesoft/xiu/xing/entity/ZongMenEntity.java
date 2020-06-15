package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> zong_men的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-15 <br>
 * @since V1.0<br>
 * @see ZongMenEntity <br>
 */
@Entity
@Table(name = "zong_men")
public class ZongMenEntity extends BaseEntity {

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

    /** zong_men_code */
    @Column(name = "zong_men_code")
    private String zongMenCode;

    /** zong_men_name */
    @Column(name = "zong_men_name")
    private String zongMenName;

    /** zong_men_miao_shu */
    @Column(name = "zong_men_miao_shu")
    private String zongMenMiaoShu;

    /** zong_men_fen_lei */
    @Column(name = "zong_men_fen_lei")
    private String zongMenFenLei;

    /** di_ming_id */
    @Column(name = "di_ming_id")
    private String diMingId;

    /** di_tu_id */
    @Column(name = "di_tu_id")
    private String diTuId;

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

    public String getZongMenCode() {
        return this.zongMenCode;
    }

    public void setZongMenCode(String zongMenCode) {
        this.zongMenCode = zongMenCode;
    }

    public String getZongMenName() {
        return this.zongMenName;
    }

    public void setZongMenName(String zongMenName) {
        this.zongMenName = zongMenName;
    }

    public String getZongMenMiaoShu() {
        return this.zongMenMiaoShu;
    }

    public void setZongMenMiaoShu(String zongMenMiaoShu) {
        this.zongMenMiaoShu = zongMenMiaoShu;
    }

    public String getZongMenFenLei() {
        return this.zongMenFenLei;
    }

    public void setZongMenFenLei(String zongMenFenLei) {
        this.zongMenFenLei = zongMenFenLei;
    }

    public String getDiMingId() {
        return this.diMingId;
    }

    public void setDiMingId(String diMingId) {
        this.diMingId = diMingId;
    }

    public String getDiTuId() {
        return this.diTuId;
    }

    public void setDiTuId(String diTuId) {
        this.diTuId = diTuId;
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
