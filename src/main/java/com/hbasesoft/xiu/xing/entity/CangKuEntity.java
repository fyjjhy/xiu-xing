package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> cang_ku的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-17 <br>
 * @since V1.0<br>
 * @see CangKuEntity <br>
 */
@Entity
@Table(name = "cang_ku")
public class CangKuEntity extends BaseEntity {

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

    /** ling_wu_fen_lei */
    @Column(name = "ling_wu_fen_lei")
    private String lingWuFenLei;

    /** ling_wu_shu_xing */
    @Column(name = "ling_wu_shu_xing")
    private String lingWuShuXing;

    /** ling_wu_state */
    @Column(name = "ling_wu_state")
    private String lingWuState;

    /** ling_wu_name */
    @Column(name = "ling_wu_name")
    private String lingWuName;

    /** ling_wu_id */
    @Column(name = "ling_wu_id")
    private String lingWuId;

    /** ling_wu_shu_liang */
    @Column(name = "ling_wu_shu_liang")
    private String lingWuShuLiang;

    /** dan_wei */
    @Column(name = "dan_wei")
    private String danWei;

    /** ling_wu_miao_shu */
    @Column(name = "ling_wu_miao_shu")
    private String lingWuMiaoShu;

    /** suo_shu_fen_lei */
    @Column(name = "suo_shu_fen_lei")
    private String suoShuFenLei;

    /** suo_shu_zhe */
    @Column(name = "suo_shu_zhe")
    private String suoShuZhe;

    /** suo_shu_id */
    @Column(name = "suo_shu_id")
    private String suoShuId;

    /** jing_jie_id */
    @Column(name = "jing_jie_id")
    private String jingJieId;

    /** jing_jie_name */
    @Column(name = "jing_jie_name")
    private String jingJieName;

    /** pin_ji_id */
    @Column(name = "pin_ji_id")
    private String pinJiId;

    /** pin_ji_name */
    @Column(name = "pin_ji_name")
    private String pinJiName;

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

    public String getLingWuState() {
        return this.lingWuState;
    }

    public void setLingWuState(String lingWuState) {
        this.lingWuState = lingWuState;
    }

    public String getLingWuName() {
        return this.lingWuName;
    }

    public void setLingWuName(String lingWuName) {
        this.lingWuName = lingWuName;
    }

    public String getLingWuId() {
        return this.lingWuId;
    }

    public void setLingWuId(String lingWuId) {
        this.lingWuId = lingWuId;
    }

    public String getLingWuShuLiang() {
        return this.lingWuShuLiang;
    }

    public void setLingWuShuLiang(String lingWuShuLiang) {
        this.lingWuShuLiang = lingWuShuLiang;
    }

    public String getDanWei() {
        return this.danWei;
    }

    public void setDanWei(String danWei) {
        this.danWei = danWei;
    }

    public String getLingWuMiaoShu() {
        return this.lingWuMiaoShu;
    }

    public void setLingWuMiaoShu(String lingWuMiaoShu) {
        this.lingWuMiaoShu = lingWuMiaoShu;
    }

    public String getSuoShuFenLei() {
        return this.suoShuFenLei;
    }

    public void setSuoShuFenLei(String suoShuFenLei) {
        this.suoShuFenLei = suoShuFenLei;
    }

    public String getSuoShuZhe() {
        return this.suoShuZhe;
    }

    public void setSuoShuZhe(String suoShuZhe) {
        this.suoShuZhe = suoShuZhe;
    }

    public String getSuoShuId() {
        return this.suoShuId;
    }

    public void setSuoShuId(String suoShuId) {
        this.suoShuId = suoShuId;
    }

    public String getJingJieId() {
        return this.jingJieId;
    }

    public void setJingJieId(String jingJieId) {
        this.jingJieId = jingJieId;
    }

    public String getJingJieName() {
        return this.jingJieName;
    }

    public void setJingJieName(String jingJieName) {
        this.jingJieName = jingJieName;
    }

    public String getPinJiId() {
        return this.pinJiId;
    }

    public void setPinJiId(String pinJiId) {
        this.pinJiId = pinJiId;
    }

    public String getPinJiName() {
        return this.pinJiName;
    }

    public void setPinJiName(String pinJiName) {
        this.pinJiName = pinJiName;
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
