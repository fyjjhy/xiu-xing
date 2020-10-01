package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> pin_ji的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-09-20 <br>
 * @since V1.0<br>
 * @see PinJiEntity <br>
 */
@Entity
@Table(name = "pin_ji")
public class PinJiEntity extends BaseEntity {

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

    /** pin_ji_code */
    @Column(name = "pin_ji_code")
    private String pinJiCode;

    /** pin_ji_name */
    @Column(name = "pin_ji_name")
    private String pinJiName;

    /** pin_ji_miao_shu */
    @Column(name = "pin_ji_miao_shu")
    private String pinJiMiaoShu;

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

    public String getPinJiCode() {
        return this.pinJiCode;
    }

    public void setPinJiCode(String pinJiCode) {
        this.pinJiCode = pinJiCode;
    }

    public String getPinJiName() {
        return this.pinJiName;
    }

    public void setPinJiName(String pinJiName) {
        this.pinJiName = pinJiName;
    }

    public String getPinJiMiaoShu() {
        return this.pinJiMiaoShu;
    }

    public void setPinJiMiaoShu(String pinJiMiaoShu) {
        this.pinJiMiaoShu = pinJiMiaoShu;
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
