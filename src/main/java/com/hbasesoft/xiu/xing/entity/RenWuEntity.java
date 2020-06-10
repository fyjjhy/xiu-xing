package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ren_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-31 <br>
 * @since V1.0<br>
 * @see RenWuEntity <br>
 */
@Entity
@Table(name = "ren_wu")
public class RenWuEntity extends BaseEntity {

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

    /** ren_wu_code */
    @Column(name = "ren_wu_code")
    private String renWuCode;

    /** ren_wu_name */
    @Column(name = "ren_wu_name")
    private String renWuName;

    /** ceng_yong_ming */
    @Column(name = "ceng_yong_ming")
    private String cengYongMing;

    /** ren_wu_fen_lei */
    @Column(name = "ren_wu_fen_lei")
    private String renWuFenLei;

    /** ren_wu_state */
    @Column(name = "ren_wu_state")
    private String renWuState;

    /** ren_wu_shu_xing */
    @Column(name = "ren_wu_shu_xing")
    private String renWuShuXing;

    /** ren_wu_miao_shu */
    @Column(name = "ren_wu_miao_shu")
    private String renWuMiaoShu;

    /** di_tu_id */
    @Column(name = "di_tu_id")
    private String diTuId;

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

    public String getRenWuCode() {
        return this.renWuCode;
    }

    public void setRenWuCode(String renWuCode) {
        this.renWuCode = renWuCode;
    }

    public String getRenWuName() {
        return this.renWuName;
    }

    public void setRenWuName(String renWuName) {
        this.renWuName = renWuName;
    }

    public String getCengYongMing() {
        return this.cengYongMing;
    }

    public void setCengYongMing(String cengYongMing) {
        this.cengYongMing = cengYongMing;
    }

    public String getRenWuFenLei() {
        return this.renWuFenLei;
    }

    public void setRenWuFenLei(String renWuFenLei) {
        this.renWuFenLei = renWuFenLei;
    }

    public String getRenWuState() {
        return this.renWuState;
    }

    public void setRenWuState(String renWuState) {
        this.renWuState = renWuState;
    }

    public String getRenWuShuXing() {
        return this.renWuShuXing;
    }

    public void setRenWuShuXing(String renWuShuXing) {
        this.renWuShuXing = renWuShuXing;
    }

    public String getRenWuMiaoShu() {
        return this.renWuMiaoShu;
    }

    public void setRenWuMiaoShu(String renWuMiaoShu) {
        this.renWuMiaoShu = renWuMiaoShu;
    }

    public String getDiTuId() {
        return this.diTuId;
    }

    public void setDiTuId(String diTuId) {
        this.diTuId = diTuId;
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
