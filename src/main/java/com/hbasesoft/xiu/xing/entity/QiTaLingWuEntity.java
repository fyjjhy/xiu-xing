package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> qi_ta_ling_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see QiTaLingWuEntity <br>
 */
@Entity
@Table(name = "qi_ta_ling_wu")
public class QiTaLingWuEntity extends BaseEntity {

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

    /** ling_wu_code */
    @Column(name = "ling_wu_code")
    private String lingWuCode;

    /** ling_wu_name */
    @Column(name = "ling_wu_name")
    private String lingWuName;

    /** ling_wu_fen_lei */
    @Column(name = "ling_wu_fen_lei")
    private String lingWuFenLei;

    /** ling_wu_shu_xing */
    @Column(name = "ling_wu_shu_xing")
    private String lingWuShuXing;

    /** ling_wu_miao_shu */
    @Column(name = "ling_wu_miao_shu")
    private String lingWuMiaoShu;

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

    public String getLingWuCode() {
        return this.lingWuCode;
    }

    public void setLingWuCode(String lingWuCode) {
        this.lingWuCode = lingWuCode;
    }

    public String getLingWuName() {
        return this.lingWuName;
    }

    public void setLingWuName(String lingWuName) {
        this.lingWuName = lingWuName;
    }

    public String getLingWuFenLei() {
        return this.lingWuFenLei;
    }

    public void setLingWuFenLei(String lingWuFenLei) {
        this.lingWuFenLei = lingWuFenLei;
    }

    public String getLingWuShuXing() {
        return this.lingWuShuXing;
    }

    public void setLingWuShuXing(String lingWuShuXing) {
        this.lingWuShuXing = lingWuShuXing;
    }

    public String getLingWuMiaoShu() {
        return this.lingWuMiaoShu;
    }

    public void setLingWuMiaoShu(String lingWuMiaoShu) {
        this.lingWuMiaoShu = lingWuMiaoShu;
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
