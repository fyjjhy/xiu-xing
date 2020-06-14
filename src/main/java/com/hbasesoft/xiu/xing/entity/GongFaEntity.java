package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> gong_fa的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see GongFaEntity <br>
 */
@Entity
@Table(name = "gong_fa")
public class GongFaEntity extends BaseEntity {

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

    /** gong_fa_code */
    @Column(name = "gong_fa_code")
    private String gongFaCode;

    /** gong_fa_name */
    @Column(name = "gong_fa_name")
    private String gongFaName;

    /** gong_fa_fen_lei */
    @Column(name = "gong_fa_fen_lei")
    private String gongFaFenLei;

    /** gong_fa_shu_xing */
    @Column(name = "gong_fa_shu_xing")
    private String gongFaShuXing;

    /** gong_fa_miao_shu */
    @Column(name = "gong_fa_miao_shu")
    private String gongFaMiaoShu;

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

    public String getGongFaCode() {
        return this.gongFaCode;
    }

    public void setGongFaCode(String gongFaCode) {
        this.gongFaCode = gongFaCode;
    }

    public String getGongFaName() {
        return this.gongFaName;
    }

    public void setGongFaName(String gongFaName) {
        this.gongFaName = gongFaName;
    }

    public String getGongFaFenLei() {
        return this.gongFaFenLei;
    }

    public void setGongFaFenLei(String gongFaFenLei) {
        this.gongFaFenLei = gongFaFenLei;
    }

    public String getGongFaShuXing() {
        return this.gongFaShuXing;
    }

    public void setGongFaShuXing(String gongFaShuXing) {
        this.gongFaShuXing = gongFaShuXing;
    }

    public String getGongFaMiaoShu() {
        return this.gongFaMiaoShu;
    }

    public void setGongFaMiaoShu(String gongFaMiaoShu) {
        this.gongFaMiaoShu = gongFaMiaoShu;
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
