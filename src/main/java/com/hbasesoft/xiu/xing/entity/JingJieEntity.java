package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> jing_jie的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-09-20 <br>
 * @since V1.0<br>
 * @see JingJieEntity <br>
 */
@Entity
@Table(name = "jing_jie")
public class JingJieEntity extends BaseEntity {

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

    /** jing_jie_code */
    @Column(name = "jing_jie_code")
    private String jingJieCode;

    /** jing_jie_fen_lei */
    @Column(name = "jing_jie_fen_lei")
    private String jingJieFenLei;

    /** jing_jie_name */
    @Column(name = "jing_jie_name")
    private String jingJieName;

    /** jing_jie_miao_shu */
    @Column(name = "jing_jie_miao_shu")
    private String jingJieMiaoShu;

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

    public String getJingJieCode() {
        return this.jingJieCode;
    }

    public void setJingJieCode(String jingJieCode) {
        this.jingJieCode = jingJieCode;
    }

    public String getJingJieFenLei() {
        return this.jingJieFenLei;
    }

    public void setJingJieFenLei(String jingJieFenLei) {
        this.jingJieFenLei = jingJieFenLei;
    }

    public String getJingJieName() {
        return this.jingJieName;
    }

    public void setJingJieName(String jingJieName) {
        this.jingJieName = jingJieName;
    }

    public String getJingJieMiaoShu() {
        return this.jingJieMiaoShu;
    }

    public void setJingJieMiaoShu(String jingJieMiaoShu) {
        this.jingJieMiaoShu = jingJieMiaoShu;
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
