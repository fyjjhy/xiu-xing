package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> yao_shou的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-13 <br>
 * @since V1.0<br>
 * @see YaoShouEntity <br>
 */
@Entity
@Table(name = "yao_shou")
public class YaoShouEntity extends BaseEntity {

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

    /** yao_shou_code */
    @Column(name = "yao_shou_code")
    private String yaoShouCode;

    /** yao_shou_name */
    @Column(name = "yao_shou_name")
    private String yaoShouName;

    /** yao_shou_fen_lei */
    @Column(name = "yao_shou_fen_lei")
    private String yaoShouFenLei;

    /** yao_shou_shu_xing */
    @Column(name = "yao_shou_shu_xing")
    private String yaoShouShuXing;

    /** yao_shou_miao_shu */
    @Column(name = "yao_shou_miao_shu")
    private String yaoShouMiaoShu;

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

    public String getYaoShouCode() {
        return this.yaoShouCode;
    }

    public void setYaoShouCode(String yaoShouCode) {
        this.yaoShouCode = yaoShouCode;
    }

    public String getYaoShouName() {
        return this.yaoShouName;
    }

    public void setYaoShouName(String yaoShouName) {
        this.yaoShouName = yaoShouName;
    }

    public String getYaoShouFenLei() {
        return this.yaoShouFenLei;
    }

    public void setYaoShouFenLei(String yaoShouFenLei) {
        this.yaoShouFenLei = yaoShouFenLei;
    }

    public String getYaoShouShuXing() {
        return this.yaoShouShuXing;
    }

    public void setYaoShouShuXing(String yaoShouShuXing) {
        this.yaoShouShuXing = yaoShouShuXing;
    }

    public String getYaoShouMiaoShu() {
        return this.yaoShouMiaoShu;
    }

    public void setYaoShouMiaoShu(String yaoShouMiaoShu) {
        this.yaoShouMiaoShu = yaoShouMiaoShu;
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
