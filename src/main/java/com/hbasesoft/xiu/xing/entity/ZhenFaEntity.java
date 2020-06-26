package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> zhen_fa的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see ZhenFaEntity <br>
 */
@Entity
@Table(name = "zhen_fa")
public class ZhenFaEntity extends BaseEntity {

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

    /** zhen_fa_code */
    @Column(name = "zhen_fa_code")
    private String zhenFaCode;

    /** zhen_fa_name */
    @Column(name = "zhen_fa_name")
    private String zhenFaName;

    /** zhen_fa_shu_xing */
    @Column(name = "zhen_fa_shu_xing")
    private String zhenFaShuXing;

    /** zhen_fa_miao_shu */
    @Column(name = "zhen_fa_miao_shu")
    private String zhenFaMiaoShu;

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

    public String getZhenFaCode() {
        return this.zhenFaCode;
    }

    public void setZhenFaCode(String zhenFaCode) {
        this.zhenFaCode = zhenFaCode;
    }

    public String getZhenFaName() {
        return this.zhenFaName;
    }

    public void setZhenFaName(String zhenFaName) {
        this.zhenFaName = zhenFaName;
    }

    public String getZhenFaShuXing() {
        return this.zhenFaShuXing;
    }

    public void setZhenFaShuXing(String zhenFaShuXing) {
        this.zhenFaShuXing = zhenFaShuXing;
    }

    public String getZhenFaMiaoShu() {
        return this.zhenFaMiaoShu;
    }

    public void setZhenFaMiaoShu(String zhenFaMiaoShu) {
        this.zhenFaMiaoShu = zhenFaMiaoShu;
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
