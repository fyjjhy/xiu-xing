package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> xiao_shuo的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-12-20 <br>
 * @since V1.0<br>
 * @see XiaoShuoEntity <br>
 */
@Entity
@Table(name = "xiao_shuo")
public class XiaoShuoEntity extends BaseEntity {

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

    /** name */
    @Column(name = "name")
    private String name;

    /** zuo_zhe */
    @Column(name = "zuo_zhe")
    private String zuoZhe;

    /** miao_shu */
    @Column(name = "miao_shu")
    private String miaoShu;

    /** topping_time */
    @Column(name = "topping_time")
    private java.util.Date toppingTime;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZuoZhe() {
        return this.zuoZhe;
    }

    public void setZuoZhe(String zuoZhe) {
        this.zuoZhe = zuoZhe;
    }

    public String getMiaoShu() {
        return this.miaoShu;
    }

    public void setMiaoShu(String miaoShu) {
        this.miaoShu = miaoShu;
    }

    public java.util.Date getToppingTime() {
        return this.toppingTime;
    }

    public void setToppingTime(java.util.Date toppingTime) {
        this.toppingTime = toppingTime;
    }

}
