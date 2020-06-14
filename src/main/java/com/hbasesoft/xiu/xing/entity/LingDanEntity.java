package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ling_dan的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see LingDanEntity <br>
 */
@Entity
@Table(name = "ling_dan")
public class LingDanEntity extends BaseEntity {

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

    /** ling_dan_code */
    @Column(name = "ling_dan_code")
    private String lingDanCode;

    /** ling_dan_name */
    @Column(name = "ling_dan_name")
    private String lingDanName;

    /** ling_dan_fen_lei */
    @Column(name = "ling_dan_fen_lei")
    private String lingDanFenLei;

    /** ling_dan_shu_xing */
    @Column(name = "ling_dan_shu_xing")
    private String lingDanShuXing;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** ling_dan_miao_shu */
    @Column(name = "ling_dan_miao_shu")
    private String lingDanMiaoShu;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLingDanCode() {
        return this.lingDanCode;
    }

    public void setLingDanCode(String lingDanCode) {
        this.lingDanCode = lingDanCode;
    }

    public String getLingDanName() {
        return this.lingDanName;
    }

    public void setLingDanName(String lingDanName) {
        this.lingDanName = lingDanName;
    }

    public String getLingDanFenLei() {
        return this.lingDanFenLei;
    }

    public void setLingDanFenLei(String lingDanFenLei) {
        this.lingDanFenLei = lingDanFenLei;
    }

    public String getLingDanShuXing() {
        return this.lingDanShuXing;
    }

    public void setLingDanShuXing(String lingDanShuXing) {
        this.lingDanShuXing = lingDanShuXing;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLingDanMiaoShu() {
        return this.lingDanMiaoShu;
    }

    public void setLingDanMiaoShu(String lingDanMiaoShu) {
        this.lingDanMiaoShu = lingDanMiaoShu;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
