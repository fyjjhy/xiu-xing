package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> shu_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-22 <br>
 * @since V1.0<br>
 * @see ShuHisEntity <br>
 */
@Entity
@Table(name = "shu_his")
public class ShuHisEntity extends BaseEntity {

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

    /** shu_id */
    @Column(name = "shu_id")
    private String shuId;

    /** shu_code */
    @Column(name = "shu_code")
    private String shuCode;

    /** shu_name */
    @Column(name = "shu_name")
    private String shuName;

    /** shu_state */
    @Column(name = "shu_state")
    private String shuState;

    /** shu_fen_lei */
    @Column(name = "shu_fen_lei")
    private String shuFenLei;

    /** shu_jing_jie_id */
    @Column(name = "shu_jing_jie_id")
    private String shuJingJieId;

    /** shu_pin_ji_id */
    @Column(name = "shu_pin_ji_id")
    private String shuPinJiId;

    /** shu_xiu_xing */
    @Column(name = "shu_xiu_xing")
    private String shuXiuXing;

    /** shu_miao_shu */
    @Column(name = "shu_miao_shu")
    private String shuMiaoShu;

    /** addr_id */
    @Column(name = "addr_id")
    private String addrId;

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

    public String getShuId() {
        return this.shuId;
    }

    public void setShuId(String shuId) {
        this.shuId = shuId;
    }

    public String getShuCode() {
        return this.shuCode;
    }

    public void setShuCode(String shuCode) {
        this.shuCode = shuCode;
    }

    public String getShuName() {
        return this.shuName;
    }

    public void setShuName(String shuName) {
        this.shuName = shuName;
    }

    public String getShuState() {
        return this.shuState;
    }

    public void setShuState(String shuState) {
        this.shuState = shuState;
    }

    public String getShuFenLei() {
        return this.shuFenLei;
    }

    public void setShuFenLei(String shuFenLei) {
        this.shuFenLei = shuFenLei;
    }

    public String getShuJingJieId() {
        return this.shuJingJieId;
    }

    public void setShuJingJieId(String shuJingJieId) {
        this.shuJingJieId = shuJingJieId;
    }

    public String getShuPinJiId() {
        return this.shuPinJiId;
    }

    public void setShuPinJiId(String shuPinJiId) {
        this.shuPinJiId = shuPinJiId;
    }

    public String getShuXiuXing() {
        return this.shuXiuXing;
    }

    public void setShuXiuXing(String shuXiuXing) {
        this.shuXiuXing = shuXiuXing;
    }

    public String getShuMiaoShu() {
        return this.shuMiaoShu;
    }

    public void setShuMiaoShu(String shuMiaoShu) {
        this.shuMiaoShu = shuMiaoShu;
    }

    public String getAddrId() {
        return this.addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
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
