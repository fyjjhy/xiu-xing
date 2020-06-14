package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ling_qi的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see LingQiEntity <br>
 */
@Entity
@Table(name = "ling_qi")
public class LingQiEntity extends BaseEntity {

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

    /** ling_qi_code */
    @Column(name = "ling_qi_code")
    private String lingQiCode;

    /** ling_qi_name */
    @Column(name = "ling_qi_name")
    private String lingQiName;

    /** ling_qi_shu_xing */
    @Column(name = "ling_qi_shu_xing")
    private String lingQiShuXing;

    /** ling_qi_fen_lei */
    @Column(name = "ling_qi_fen_lei")
    private String lingQiFenLei;

    /** ling_qi_miao_shu */
    @Column(name = "ling_qi_miao_shu")
    private String lingQiMiaoShu;

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

    public String getLingQiCode() {
        return this.lingQiCode;
    }

    public void setLingQiCode(String lingQiCode) {
        this.lingQiCode = lingQiCode;
    }

    public String getLingQiName() {
        return this.lingQiName;
    }

    public void setLingQiName(String lingQiName) {
        this.lingQiName = lingQiName;
    }

    public String getLingQiShuXing() {
        return this.lingQiShuXing;
    }

    public void setLingQiShuXing(String lingQiShuXing) {
        this.lingQiShuXing = lingQiShuXing;
    }

    public String getLingQiFenLei() {
        return this.lingQiFenLei;
    }

    public void setLingQiFenLei(String lingQiFenLei) {
        this.lingQiFenLei = lingQiFenLei;
    }

    public String getLingQiMiaoShu() {
        return this.lingQiMiaoShu;
    }

    public void setLingQiMiaoShu(String lingQiMiaoShu) {
        this.lingQiMiaoShu = lingQiMiaoShu;
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
