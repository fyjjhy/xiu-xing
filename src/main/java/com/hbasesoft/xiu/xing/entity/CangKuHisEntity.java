package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> cang_ku_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-21 <br>
 * @since V1.0<br>
 * @see CangKuHisEntity <br>
 */
@Entity
@Table(name = "cang_ku_his")
public class CangKuHisEntity extends BaseEntity {

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

    /** cang_ku_id */
    @Column(name = "cang_ku_id")
    private String cangKuId;

    /** cong_shu_xing */
    @Column(name = "cong_shu_xing")
    private String congShuXing;

    /** cong_state */
    @Column(name = "cong_state")
    private String congState;

    /** cong_shu_liang */
    @Column(name = "cong_shu_liang")
    private String congShuLiang;

    /** dan_wei */
    @Column(name = "dan_wei")
    private String danWei;

    /** cong_his_id */
    @Column(name = "cong_his_id")
    private String congHisId;

    /** cong_id */
    @Column(name = "cong_id")
    private String congId;

    /** cong_jing_jie_id */
    @Column(name = "cong_jing_jie_id")
    private String congJingJieId;

    /** cong_pin_ji_id */
    @Column(name = "cong_pin_ji_id")
    private String congPinJiId;

    /** cong_xiu_xing */
    @Column(name = "cong_xiu_xing")
    private String congXiuXing;

    /** shu_his_id */
    @Column(name = "shu_his_id")
    private String shuHisId;

    /** shu_id */
    @Column(name = "shu_id")
    private String shuId;

    /** shu_jing_jie_id */
    @Column(name = "shu_jing_jie_id")
    private String shuJingJieId;

    /** shu_pin_ji_id */
    @Column(name = "shu_pin_ji_id")
    private String shuPinJiId;

    /** hen_ji_id */
    @Column(name = "hen_ji_id")
    private String henJiId;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** bei_zhu */
    @Column(name = "bei_zhu")
    private String beiZhu;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCangKuId() {
        return this.cangKuId;
    }

    public void setCangKuId(String cangKuId) {
        this.cangKuId = cangKuId;
    }

    public String getCongShuXing() {
        return this.congShuXing;
    }

    public void setCongShuXing(String congShuXing) {
        this.congShuXing = congShuXing;
    }

    public String getCongState() {
        return this.congState;
    }

    public void setCongState(String congState) {
        this.congState = congState;
    }

    public String getCongShuLiang() {
        return this.congShuLiang;
    }

    public void setCongShuLiang(String congShuLiang) {
        this.congShuLiang = congShuLiang;
    }

    public String getDanWei() {
        return this.danWei;
    }

    public void setDanWei(String danWei) {
        this.danWei = danWei;
    }

    public String getCongHisId() {
        return this.congHisId;
    }

    public void setCongHisId(String congHisId) {
        this.congHisId = congHisId;
    }

    public String getCongId() {
        return this.congId;
    }

    public void setCongId(String congId) {
        this.congId = congId;
    }

    public String getCongJingJieId() {
        return this.congJingJieId;
    }

    public void setCongJingJieId(String congJingJieId) {
        this.congJingJieId = congJingJieId;
    }

    public String getCongPinJiId() {
        return this.congPinJiId;
    }

    public void setCongPinJiId(String congPinJiId) {
        this.congPinJiId = congPinJiId;
    }

    public String getCongXiuXing() {
        return this.congXiuXing;
    }

    public void setCongXiuXing(String congXiuXing) {
        this.congXiuXing = congXiuXing;
    }

    public String getShuHisId() {
        return this.shuHisId;
    }

    public void setShuHisId(String shuHisId) {
        this.shuHisId = shuHisId;
    }

    public String getShuId() {
        return this.shuId;
    }

    public void setShuId(String shuId) {
        this.shuId = shuId;
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

    public String getHenJiId() {
        return this.henJiId;
    }

    public void setHenJiId(String henJiId) {
        this.henJiId = henJiId;
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

    public String getBeiZhu() {
        return this.beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

}
