package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ling_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-26 <br>
 * @since V1.0<br>
 * @see LingWuEntity <br>
 */
@Entity
@Table(name = "ling_wu")
public class LingWuEntity extends BaseEntity {

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

    /** ling_wu_state */
    @Column(name = "ling_wu_state")
    private String lingWuState;

    /** ling_wu_fen_lei */
    @Column(name = "ling_wu_fen_lei")
    private String lingWuFenLei;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** ling_wu_miao_shu */
    @Column(name = "ling_wu_miao_shu")
    private String lingWuMiaoShu;

    /** ling_wu_shu_xing */
    @Column(name = "ling_wu_shu_xing")
    private String lingWuShuXing;

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

    public String getLingWuState() {
        return this.lingWuState;
    }

    public void setLingWuState(String lingWuState) {
        this.lingWuState = lingWuState;
    }

    public String getLingWuFenLei() {
        return this.lingWuFenLei;
    }

    public void setLingWuFenLei(String lingWuFenLei) {
        this.lingWuFenLei = lingWuFenLei;
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

    public String getLingWuMiaoShu() {
        return this.lingWuMiaoShu;
    }

    public void setLingWuMiaoShu(String lingWuMiaoShu) {
        this.lingWuMiaoShu = lingWuMiaoShu;
    }

    public String getLingWuShuXing() {
        return this.lingWuShuXing;
    }

    public void setLingWuShuXing(String lingWuShuXing) {
        this.lingWuShuXing = lingWuShuXing;
    }

}
