package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> sheng_cheng的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-11-21 <br>
 * @since V1.0<br>
 * @see ShengChengEntity <br>
 */
@Entity
@Table(name = "sheng_cheng")
public class ShengChengEntity extends BaseEntity {

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

    /** sheng_cheng_code */
    @Column(name = "sheng_cheng_code")
    private String shengChengCode;

    /** sheng_cheng_name */
    @Column(name = "sheng_cheng_name")
    private String shengChengName;

    /** sheng_cheng_state */
    @Column(name = "sheng_cheng_state")
    private String shengChengState;

    /** sheng_cheng_miao_shu */
    @Column(name = "sheng_cheng_miao_shu")
    private String shengChengMiaoShu;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShengChengCode() {
        return this.shengChengCode;
    }

    public void setShengChengCode(String shengChengCode) {
        this.shengChengCode = shengChengCode;
    }

    public String getShengChengName() {
        return this.shengChengName;
    }

    public void setShengChengName(String shengChengName) {
        this.shengChengName = shengChengName;
    }

    public String getShengChengState() {
        return this.shengChengState;
    }

    public void setShengChengState(String shengChengState) {
        this.shengChengState = shengChengState;
    }

    public String getShengChengMiaoShu() {
        return this.shengChengMiaoShu;
    }

    public void setShengChengMiaoShu(String shengChengMiaoShu) {
        this.shengChengMiaoShu = shengChengMiaoShu;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
