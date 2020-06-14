package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> kui_lei的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see KuiLeiEntity <br>
 */
@Entity
@Table(name = "kui_lei")
public class KuiLeiEntity extends BaseEntity {

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

    /** kui_lei_code */
    @Column(name = "kui_lei_code")
    private String kuiLeiCode;

    /** kui_lei_name */
    @Column(name = "kui_lei_name")
    private String kuiLeiName;

    /** kui_lei_shu_xing */
    @Column(name = "kui_lei_shu_xing")
    private String kuiLeiShuXing;

    /** kui_lei_fen_lei */
    @Column(name = "kui_lei_fen_lei")
    private String kuiLeiFenLei;

    /** kui_lei_miao_shu */
    @Column(name = "kui_lei_miao_shu")
    private String kuiLeiMiaoShu;

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

    public String getKuiLeiCode() {
        return this.kuiLeiCode;
    }

    public void setKuiLeiCode(String kuiLeiCode) {
        this.kuiLeiCode = kuiLeiCode;
    }

    public String getKuiLeiName() {
        return this.kuiLeiName;
    }

    public void setKuiLeiName(String kuiLeiName) {
        this.kuiLeiName = kuiLeiName;
    }

    public String getKuiLeiShuXing() {
        return this.kuiLeiShuXing;
    }

    public void setKuiLeiShuXing(String kuiLeiShuXing) {
        this.kuiLeiShuXing = kuiLeiShuXing;
    }

    public String getKuiLeiFenLei() {
        return this.kuiLeiFenLei;
    }

    public void setKuiLeiFenLei(String kuiLeiFenLei) {
        this.kuiLeiFenLei = kuiLeiFenLei;
    }

    public String getKuiLeiMiaoShu() {
        return this.kuiLeiMiaoShu;
    }

    public void setKuiLeiMiaoShu(String kuiLeiMiaoShu) {
        this.kuiLeiMiaoShu = kuiLeiMiaoShu;
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
