package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> suo_shu_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-07-19 <br>
 * @since V1.0<br>
 * @see SuoShuHisEntity <br>
 */
@Entity
@Table(name = "suo_shu_his")
public class SuoShuHisEntity extends BaseEntity {

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

    /** suo_shu_id */
    @Column(name = "suo_shu_id")
    private String suoShuId;

    /** suo_shu_code */
    @Column(name = "suo_shu_code")
    private String suoShuCode;

    /** suo_shu_name */
    @Column(name = "suo_shu_name")
    private String suoShuName;

    /** suo_shu_fen_lei */
    @Column(name = "suo_shu_fen_lei")
    private String suoShuFenLei;

    /** suo_shu_miao_shu */
    @Column(name = "suo_shu_miao_shu")
    private String suoShuMiaoShu;

    /** update_time */
    @Column(name = "update_time")
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    /** addr_id */
    @Column(name = "addr_id")
    private String addrId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuoShuId() {
        return this.suoShuId;
    }

    public void setSuoShuId(String suoShuId) {
        this.suoShuId = suoShuId;
    }

    public String getSuoShuCode() {
        return this.suoShuCode;
    }

    public void setSuoShuCode(String suoShuCode) {
        this.suoShuCode = suoShuCode;
    }

    public String getSuoShuName() {
        return this.suoShuName;
    }

    public void setSuoShuName(String suoShuName) {
        this.suoShuName = suoShuName;
    }

    public String getSuoShuFenLei() {
        return this.suoShuFenLei;
    }

    public void setSuoShuFenLei(String suoShuFenLei) {
        this.suoShuFenLei = suoShuFenLei;
    }

    public String getSuoShuMiaoShu() {
        return this.suoShuMiaoShu;
    }

    public void setSuoShuMiaoShu(String suoShuMiaoShu) {
        this.suoShuMiaoShu = suoShuMiaoShu;
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

    public String getAddrId() {
        return this.addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

}
