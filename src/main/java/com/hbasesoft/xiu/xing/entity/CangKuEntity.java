package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * <Description> cang_ku的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-09-06 <br>
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

    /** ling_wu_shu_xing */
    @Column(name = "ling_wu_shu_xing")
    private String lingWuShuXing;

    /** ling_wu_state */
    @Column(name = "ling_wu_state")
    private String lingWuState;

    /** ling_wu_shu_liang */
    @Column(name = "ling_wu_shu_liang")
    private String lingWuShuLiang;

    /** dan_wei */
    @Column(name = "dan_wei")
    private String danWei;

    /** jing_jie_id */
    @Column(name = "jing_jie_id")
    private String jingJieId;

    /** pin_ji_id */
    @Column(name = "pin_ji_id")
    private String pinJiId;

    /** suo_shu_id */
    @Column(name = "suo_shu_id")
    private String suoShuId;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** suo_shu_pin_ji_id */
    @Column(name = "suo_shu_pin_ji_id")
    private String suoShuPinJiId;

    /** suo_shu_jing_jie_id */
    @Column(name = "suo_shu_jing_jie_id")
    private String suoShuJingJieId;

    /** ling_wu_his_id */
    @Column(name = "ling_wu_his_id")
    private String lingWuHisId;

    /** suo_shu_his_id */
    @Column(name = "suo_shu_his_id")
    private String suoShuHisId;

    /** hen_ji_id */
    @Column(name = "hen_ji_id")
    private String henJiId;

    /** ling_wu_id */
    @Column(name = "ling_wu_id")
    private String lingWuId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getJingJieId() {
        return this.jingJieId;
    }

    public void setJingJieId(String jingJieId) {
        this.jingJieId = jingJieId;
    }

    public String getPinJiId() {
        return this.pinJiId;
    }

    public void setPinJiId(String pinJiId) {
        this.pinJiId = pinJiId;
    }

    public String getSuoShuId() {
        return this.suoShuId;
    }

    public void setSuoShuId(String suoShuId) {
        this.suoShuId = suoShuId;
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

    public String getSuoShuPinJiId() {
        return this.suoShuPinJiId;
    }

    public void setSuoShuPinJiId(String suoShuPinJiId) {
        this.suoShuPinJiId = suoShuPinJiId;
    }

    public String getSuoShuJingJieId() {
        return this.suoShuJingJieId;
    }

    public void setSuoShuJingJieId(String suoShuJingJieId) {
        this.suoShuJingJieId = suoShuJingJieId;
    }

    public String getLingWuHisId() {
        return this.lingWuHisId;
    }

    public void setLingWuHisId(String lingWuHisId) {
        this.lingWuHisId = lingWuHisId;
    }

    public String getSuoShuHisId() {
        return this.suoShuHisId;
    }

    public void setSuoShuHisId(String suoShuHisId) {
        this.suoShuHisId = suoShuHisId;
    }

    public String getHenJiId() {
        return this.henJiId;
    }

    public void setHenJiId(String henJiId) {
        this.henJiId = henJiId;
    }

    public String getLingWuId() {
        return this.lingWuId;
    }

    public void setLingWuId(String lingWuId) {
        this.lingWuId = lingWuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CangKuEntity that = (CangKuEntity) o;
        return Objects.equals(lingWuShuXing, that.lingWuShuXing) &&
                Objects.equals(lingWuState, that.lingWuState) &&
                Objects.equals(lingWuShuLiang, that.lingWuShuLiang) &&
                Objects.equals(danWei, that.danWei) &&
                Objects.equals(jingJieId, that.jingJieId) &&
                Objects.equals(pinJiId, that.pinJiId) &&
                Objects.equals(suoShuId, that.suoShuId) &&
                Objects.equals(xiaoShuoId, that.xiaoShuoId) &&
                Objects.equals(suoShuPinJiId, that.suoShuPinJiId) &&
                Objects.equals(suoShuJingJieId, that.suoShuJingJieId) &&
                Objects.equals(lingWuHisId, that.lingWuHisId) &&
                Objects.equals(suoShuHisId, that.suoShuHisId) &&
                Objects.equals(henJiId, that.henJiId) &&
                Objects.equals(lingWuId, that.lingWuId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lingWuShuXing, lingWuState, lingWuShuLiang, danWei, jingJieId, pinJiId, suoShuId, xiaoShuoId, suoShuPinJiId, suoShuJingJieId, lingWuHisId, suoShuHisId, henJiId, lingWuId);
    }
}
