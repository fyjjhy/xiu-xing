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
 * @CreateDate 2020-08-15 <br>
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

    /** suo_shu_fen_lei */
    @Column(name = "suo_shu_fen_lei")
    private String suoShuFenLei;

    /** suo_shu_name */
    @Column(name = "suo_shu_name")
    private String suoShuName;

    /** suo_shu_id */
    @Column(name = "suo_shu_id")
    private String suoShuId;

    /** suo_shu_miao_shu */
    @Column(name = "suo_shu_miao_shu")
    private String suoShuMiaoShu;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** suo_shu_pin_ji_name */
    @Column(name = "suo_shu_pin_ji_name")
    private String suoShuPinJiName;

    /** suo_shu_pin_ji_id */
    @Column(name = "suo_shu_pin_ji_id")
    private String suoShuPinJiId;

    /** suo_shu_jing_jie_name */
    @Column(name = "suo_shu_jing_jie_name")
    private String suoShuJingJieName;

    /** suo_shu_jing_jie_id */
    @Column(name = "suo_shu_jing_jie_id")
    private String suoShuJingJieId;

    /** bei_zhu */
    @Column(name = "bei_zhu")
    private String beiZhu;

    /** shi_jian */
    @Column(name = "shi_jian")
    private String shiJian;

    /** xiu_xing_sui_yue */
    @Column(name = "xiu_xing_sui_yue")
    private String xiuXingSuiYue;

    /** addr_id */
    @Column(name = "addr_id")
    private String addrId;

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

    public String getSuoShuFenLei() {
        return this.suoShuFenLei;
    }

    public void setSuoShuFenLei(String suoShuFenLei) {
        this.suoShuFenLei = suoShuFenLei;
    }

    public String getSuoShuName() {
        return this.suoShuName;
    }

    public void setSuoShuName(String suoShuName) {
        this.suoShuName = suoShuName;
    }

    public String getSuoShuId() {
        return this.suoShuId;
    }

    public void setSuoShuId(String suoShuId) {
        this.suoShuId = suoShuId;
    }

    public String getSuoShuMiaoShu() {
        return this.suoShuMiaoShu;
    }

    public void setSuoShuMiaoShu(String suoShuMiaoShu) {
        this.suoShuMiaoShu = suoShuMiaoShu;
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

    public String getSuoShuPinJiName() {
        return this.suoShuPinJiName;
    }

    public void setSuoShuPinJiName(String suoShuPinJiName) {
        this.suoShuPinJiName = suoShuPinJiName;
    }

    public String getSuoShuPinJiId() {
        return this.suoShuPinJiId;
    }

    public void setSuoShuPinJiId(String suoShuPinJiId) {
        this.suoShuPinJiId = suoShuPinJiId;
    }

    public String getSuoShuJingJieName() {
        return this.suoShuJingJieName;
    }

    public void setSuoShuJingJieName(String suoShuJingJieName) {
        this.suoShuJingJieName = suoShuJingJieName;
    }

    public String getSuoShuJingJieId() {
        return this.suoShuJingJieId;
    }

    public void setSuoShuJingJieId(String suoShuJingJieId) {
        this.suoShuJingJieId = suoShuJingJieId;
    }

    public String getBeiZhu() {
        return this.beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getShiJian() {
        return this.shiJian;
    }

    public void setShiJian(String shiJian) {
        this.shiJian = shiJian;
    }

    public String getXiuXingSuiYue() {
        return this.xiuXingSuiYue;
    }

    public void setXiuXingSuiYue(String xiuXingSuiYue) {
        this.xiuXingSuiYue = xiuXingSuiYue;
    }

    public String getAddrId() {
        return this.addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

}
