package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> she_ding的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-15 <br>
 * @since V1.0<br>
 * @see SheDingEntity <br>
 */
@Entity
@Table(name = "she_ding")
public class SheDingEntity extends BaseEntity {

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

    /** she_ding_code */
    @Column(name = "she_ding_code")
    private String sheDingCode;

    /** she_ding_name */
    @Column(name = "she_ding_name")
    private String sheDingName;

    /** she_ding_miao_shu */
    @Column(name = "she_ding_miao_shu")
    private String sheDingMiaoShu;

    /** she_ding_fen_lei */
    @Column(name = "she_ding_fen_lei")
    private String sheDingFenLei;

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

    public String getSheDingCode() {
        return this.sheDingCode;
    }

    public void setSheDingCode(String sheDingCode) {
        this.sheDingCode = sheDingCode;
    }

    public String getSheDingName() {
        return this.sheDingName;
    }

    public void setSheDingName(String sheDingName) {
        this.sheDingName = sheDingName;
    }

    public String getSheDingMiaoShu() {
        return this.sheDingMiaoShu;
    }

    public void setSheDingMiaoShu(String sheDingMiaoShu) {
        this.sheDingMiaoShu = sheDingMiaoShu;
    }

    public String getSheDingFenLei() {
        return this.sheDingFenLei;
    }

    public void setSheDingFenLei(String sheDingFenLei) {
        this.sheDingFenLei = sheDingFenLei;
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
