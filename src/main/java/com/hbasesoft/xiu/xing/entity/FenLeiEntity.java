package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> fen_lei的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-09-12 <br>
 * @since V1.0<br>
 * @see FenLeiEntity <br>
 */
@Entity
@Table(name = "fen_lei")
public class FenLeiEntity extends BaseEntity {

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

    /** type */
    @Column(name = "type")
    private String type;

    /** fen_lei */
    @Column(name = "fen_lei")
    private String fenLei;

    /** fen_lei_code */
    @Column(name = "fen_lei_code")
    private String fenLeiCode;

    /** fen_lei_name */
    @Column(name = "fen_lei_name")
    private String fenLeiName;

    /** fen_lei_miao_shu */
    @Column(name = "fen_lei_miao_shu")
    private String fenLeiMiaoShu;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFenLei() {
        return this.fenLei;
    }

    public void setFenLei(String fenLei) {
        this.fenLei = fenLei;
    }

    public String getFenLeiCode() {
        return this.fenLeiCode;
    }

    public void setFenLeiCode(String fenLeiCode) {
        this.fenLeiCode = fenLeiCode;
    }

    public String getFenLeiName() {
        return this.fenLeiName;
    }

    public void setFenLeiName(String fenLeiName) {
        this.fenLeiName = fenLeiName;
    }

    public String getFenLeiMiaoShu() {
        return this.fenLeiMiaoShu;
    }

    public void setFenLeiMiaoShu(String fenLeiMiaoShu) {
        this.fenLeiMiaoShu = fenLeiMiaoShu;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

}
