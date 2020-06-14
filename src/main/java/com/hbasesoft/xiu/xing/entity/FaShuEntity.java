package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> fa_shu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see FaShuEntity <br>
 */
@Entity
@Table(name = "fa_shu")
public class FaShuEntity extends BaseEntity {

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

    /** fa_shu_code */
    @Column(name = "fa_shu_code")
    private String faShuCode;

    /** fa_shu_name */
    @Column(name = "fa_shu_name")
    private String faShuName;

    /** fa_shu_fen_lei */
    @Column(name = "fa_shu_fen_lei")
    private String faShuFenLei;

    /** fa_shu_shu_xing */
    @Column(name = "fa_shu_shu_xing")
    private String faShuShuXing;

    /** fa_shu_miao_shu */
    @Column(name = "fa_shu_miao_shu")
    private String faShuMiaoShu;

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

    public String getFaShuCode() {
        return this.faShuCode;
    }

    public void setFaShuCode(String faShuCode) {
        this.faShuCode = faShuCode;
    }

    public String getFaShuName() {
        return this.faShuName;
    }

    public void setFaShuName(String faShuName) {
        this.faShuName = faShuName;
    }

    public String getFaShuFenLei() {
        return this.faShuFenLei;
    }

    public void setFaShuFenLei(String faShuFenLei) {
        this.faShuFenLei = faShuFenLei;
    }

    public String getFaShuShuXing() {
        return this.faShuShuXing;
    }

    public void setFaShuShuXing(String faShuShuXing) {
        this.faShuShuXing = faShuShuXing;
    }

    public String getFaShuMiaoShu() {
        return this.faShuMiaoShu;
    }

    public void setFaShuMiaoShu(String faShuMiaoShu) {
        this.faShuMiaoShu = faShuMiaoShu;
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
