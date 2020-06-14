package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ling_cai的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see LingCaiEntity <br>
 */
@Entity
@Table(name = "ling_cai")
public class LingCaiEntity extends BaseEntity {

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

    /** ling_cai_code */
    @Column(name = "ling_cai_code")
    private String lingCaiCode;

    /** ling_cai_name */
    @Column(name = "ling_cai_name")
    private String lingCaiName;

    /** ling_cai_state */
    @Column(name = "ling_cai_state")
    private String lingCaiState;

    /** ling_cai_miao_shu */
    @Column(name = "ling_cai_miao_shu")
    private String lingCaiMiaoShu;

    /** ling_cai_shu_xing */
    @Column(name = "ling_cai_shu_xing")
    private String lingCaiShuXing;

    /** ling_cai_fen_lei */
    @Column(name = "ling_cai_fen_lei")
    private String lingCaiFenLei;

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

    public String getLingCaiCode() {
        return this.lingCaiCode;
    }

    public void setLingCaiCode(String lingCaiCode) {
        this.lingCaiCode = lingCaiCode;
    }

    public String getLingCaiName() {
        return this.lingCaiName;
    }

    public void setLingCaiName(String lingCaiName) {
        this.lingCaiName = lingCaiName;
    }

    public String getLingCaiState() {
        return this.lingCaiState;
    }

    public void setLingCaiState(String lingCaiState) {
        this.lingCaiState = lingCaiState;
    }

    public String getLingCaiMiaoShu() {
        return this.lingCaiMiaoShu;
    }

    public void setLingCaiMiaoShu(String lingCaiMiaoShu) {
        this.lingCaiMiaoShu = lingCaiMiaoShu;
    }

    public String getLingCaiShuXing() {
        return this.lingCaiShuXing;
    }

    public void setLingCaiShuXing(String lingCaiShuXing) {
        this.lingCaiShuXing = lingCaiShuXing;
    }

    public String getLingCaiFenLei() {
        return this.lingCaiFenLei;
    }

    public void setLingCaiFenLei(String lingCaiFenLei) {
        this.lingCaiFenLei = lingCaiFenLei;
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
