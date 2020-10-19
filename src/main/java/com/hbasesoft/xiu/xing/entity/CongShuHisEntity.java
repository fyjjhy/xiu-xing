package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> cong_shu_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-08 <br>
 * @since V1.0<br>
 * @see CongShuHisEntity <br>
 */
@Entity
@Table(name = "cong_shu_his")
public class CongShuHisEntity extends BaseEntity {

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

    /** cong_shu_id */
    @Column(name = "cong_shu_id")
    private String congShuId;

    /** cong_shu_code */
    @Column(name = "cong_shu_code")
    private String congShuCode;

    /** cong_shu_name */
    @Column(name = "cong_shu_name")
    private String congShuName;

    /** cong_shu_type */
    @Column(name = "cong_shu_type")
    private String congShuType;

    /** cong_shu_fen_lei */
    @Column(name = "cong_shu_fen_lei")
    private String congShuFenLei;

    /** cong_shu_shu_xing */
    @Column(name = "cong_shu_shu_xing")
    private String congShuShuXing;

    /** cong_shu_state */
    @Column(name = "cong_shu_state")
    private String congShuState;

    /** cong_shu_jing_jie_id */
    @Column(name = "cong_shu_jing_jie_id")
    private String congShuJingJieId;

    /** cong_shu_pin_ji */
    @Column(name = "cong_shu_pin_ji")
    private String congShuPinJi;

    /** addr_id */
    @Column(name = "addr_id")
    private String addrId;

    /** cong_shu_miao_shu */
    @Column(name = "cong_shu_miao_shu")
    private String congShuMiaoShu;

    /** cong_shu_xiu_xing_time */
    @Column(name = "cong_shu_xiu_xing_time")
    private String congShuXiuXingTime;

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

    public String getCongShuId() {
        return this.congShuId;
    }

    public void setCongShuId(String congShuId) {
        this.congShuId = congShuId;
    }

    public String getCongShuCode() {
        return this.congShuCode;
    }

    public void setCongShuCode(String congShuCode) {
        this.congShuCode = congShuCode;
    }

    public String getCongShuName() {
        return this.congShuName;
    }

    public void setCongShuName(String congShuName) {
        this.congShuName = congShuName;
    }

    public String getCongShuType() {
        return this.congShuType;
    }

    public void setCongShuType(String congShuType) {
        this.congShuType = congShuType;
    }

    public String getCongShuFenLei() {
        return this.congShuFenLei;
    }

    public void setCongShuFenLei(String congShuFenLei) {
        this.congShuFenLei = congShuFenLei;
    }

    public String getCongShuShuXing() {
        return this.congShuShuXing;
    }

    public void setCongShuShuXing(String congShuShuXing) {
        this.congShuShuXing = congShuShuXing;
    }

    public String getCongShuState() {
        return this.congShuState;
    }

    public void setCongShuState(String congShuState) {
        this.congShuState = congShuState;
    }

    public String getCongShuJingJieId() {
        return this.congShuJingJieId;
    }

    public void setCongShuJingJieId(String congShuJingJieId) {
        this.congShuJingJieId = congShuJingJieId;
    }

    public String getCongShuPinJi() {
        return this.congShuPinJi;
    }

    public void setCongShuPinJi(String congShuPinJi) {
        this.congShuPinJi = congShuPinJi;
    }

    public String getAddrId() {
        return this.addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public String getCongShuMiaoShu() {
        return this.congShuMiaoShu;
    }

    public void setCongShuMiaoShu(String congShuMiaoShu) {
        this.congShuMiaoShu = congShuMiaoShu;
    }

    public String getCongShuXiuXingTime() {
        return this.congShuXiuXingTime;
    }

    public void setCongShuXiuXingTime(String congShuXiuXingTime) {
        this.congShuXiuXingTime = congShuXiuXingTime;
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
