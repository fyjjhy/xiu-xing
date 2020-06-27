package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> xiu_xing_ri_zhi的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-27 <br>
 * @since V1.0<br>
 * @see XiuXingRiZhiEntity <br>
 */
@Entity
@Table(name = "xiu_xing_ri_zhi")
public class XiuXingRiZhiEntity extends BaseEntity {

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

    /** xiu_xing_code */
    @Column(name = "xiu_xing_code")
    private String xiuXingCode;

    /** ri_zhi_code */
    @Column(name = "ri_zhi_code")
    private String riZhiCode;

    /** ri_zhi_time */
    @Column(name = "ri_zhi_time")
    private String riZhiTime;

    /** ri_zhi_di_dian */
    @Column(name = "ri_zhi_di_dian")
    private String riZhiDiDian;

    /** ri_zhi_ren_wu */
    @Column(name = "ri_zhi_ren_wu")
    private String riZhiRenWu;

    /** ri_zhi_event */
    @Column(name = "ri_zhi_event")
    private String riZhiEvent;

    /** ri_zhi */
    @Column(name = "ri_zhi")
    private String riZhi;

    /** cang_ku_id */
    @Column(name = "cang_ku_id")
    private String cangKuId;

    /** ling_wu_name */
    @Column(name = "ling_wu_name")
    private String lingWuName;

    /** ling_wu_full_name */
    @Column(name = "ling_wu_full_name")
    private String lingWuFullName;

    /** shu_liang_dan_wei */
    @Column(name = "shu_liang_dan_wei")
    private String shuLiangDanWei;

    /** ling_wu_miao_shu */
    @Column(name = "ling_wu_miao_shu")
    private String lingWuMiaoShu;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** suo_shu_name */
    @Column(name = "suo_shu_name")
    private String suoShuName;

    /** suo_shu_full_name */
    @Column(name = "suo_shu_full_name")
    private String suoShuFullName;

    /** suo_shu_miao_shu */
    @Column(name = "suo_shu_miao_shu")
    private String suoShuMiaoShu;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXiuXingCode() {
        return this.xiuXingCode;
    }

    public void setXiuXingCode(String xiuXingCode) {
        this.xiuXingCode = xiuXingCode;
    }

    public String getRiZhiCode() {
        return this.riZhiCode;
    }

    public void setRiZhiCode(String riZhiCode) {
        this.riZhiCode = riZhiCode;
    }

    public String getRiZhiTime() {
        return this.riZhiTime;
    }

    public void setRiZhiTime(String riZhiTime) {
        this.riZhiTime = riZhiTime;
    }

    public String getRiZhiDiDian() {
        return this.riZhiDiDian;
    }

    public void setRiZhiDiDian(String riZhiDiDian) {
        this.riZhiDiDian = riZhiDiDian;
    }

    public String getRiZhiRenWu() {
        return this.riZhiRenWu;
    }

    public void setRiZhiRenWu(String riZhiRenWu) {
        this.riZhiRenWu = riZhiRenWu;
    }

    public String getRiZhiEvent() {
        return this.riZhiEvent;
    }

    public void setRiZhiEvent(String riZhiEvent) {
        this.riZhiEvent = riZhiEvent;
    }

    public String getRiZhi() {
        return this.riZhi;
    }

    public void setRiZhi(String riZhi) {
        this.riZhi = riZhi;
    }

    public String getCangKuId() {
        return this.cangKuId;
    }

    public void setCangKuId(String cangKuId) {
        this.cangKuId = cangKuId;
    }

    public String getLingWuName() {
        return this.lingWuName;
    }

    public void setLingWuName(String lingWuName) {
        this.lingWuName = lingWuName;
    }

    public String getLingWuFullName() {
        return this.lingWuFullName;
    }

    public void setLingWuFullName(String lingWuFullName) {
        this.lingWuFullName = lingWuFullName;
    }

    public String getShuLiangDanWei() {
        return this.shuLiangDanWei;
    }

    public void setShuLiangDanWei(String shuLiangDanWei) {
        this.shuLiangDanWei = shuLiangDanWei;
    }

    public String getLingWuMiaoShu() {
        return this.lingWuMiaoShu;
    }

    public void setLingWuMiaoShu(String lingWuMiaoShu) {
        this.lingWuMiaoShu = lingWuMiaoShu;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

    public String getSuoShuName() {
        return this.suoShuName;
    }

    public void setSuoShuName(String suoShuName) {
        this.suoShuName = suoShuName;
    }

    public String getSuoShuFullName() {
        return this.suoShuFullName;
    }

    public void setSuoShuFullName(String suoShuFullName) {
        this.suoShuFullName = suoShuFullName;
    }

    public String getSuoShuMiaoShu() {
        return this.suoShuMiaoShu;
    }

    public void setSuoShuMiaoShu(String suoShuMiaoShu) {
        this.suoShuMiaoShu = suoShuMiaoShu;
    }

}
