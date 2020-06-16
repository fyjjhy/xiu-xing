package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ji_gou的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-16 <br>
 * @since V1.0<br>
 * @see JiGouEntity <br>
 */
@Entity
@Table(name = "ji_gou")
public class JiGouEntity extends BaseEntity {

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

    /** ji_gou_code */
    @Column(name = "ji_gou_code")
    private String jiGouCode;

    /** ji_gou_name */
    @Column(name = "ji_gou_name")
    private String jiGouName;

    /** ji_gou_fen_lei */
    @Column(name = "ji_gou_fen_lei")
    private String jiGouFenLei;

    /** ji_gou_miao_shu */
    @Column(name = "ji_gou_miao_shu")
    private String jiGouMiaoShu;

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

    public String getJiGouCode() {
        return this.jiGouCode;
    }

    public void setJiGouCode(String jiGouCode) {
        this.jiGouCode = jiGouCode;
    }

    public String getJiGouName() {
        return this.jiGouName;
    }

    public void setJiGouName(String jiGouName) {
        this.jiGouName = jiGouName;
    }

    public String getJiGouFenLei() {
        return this.jiGouFenLei;
    }

    public void setJiGouFenLei(String jiGouFenLei) {
        this.jiGouFenLei = jiGouFenLei;
    }

    public String getJiGouMiaoShu() {
        return this.jiGouMiaoShu;
    }

    public void setJiGouMiaoShu(String jiGouMiaoShu) {
        this.jiGouMiaoShu = jiGouMiaoShu;
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
