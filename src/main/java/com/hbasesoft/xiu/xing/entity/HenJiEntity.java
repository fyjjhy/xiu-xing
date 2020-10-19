package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> hen_ji的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-11 <br>
 * @since V1.0<br>
 * @see HenJiEntity <br>
 */
@Entity
@Table(name = "hen_ji")
public class HenJiEntity extends BaseEntity {

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

    /** hen_ji_code */
    @Column(name = "hen_ji_code")
    private String henJiCode;

    /** xiu_xing_shi_jian */
    @Column(name = "xiu_xing_shi_jian")
    private String xiuXingShiJian;

    /** bei_zhu */
    @Column(name = "bei_zhu")
    private String beiZhu;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHenJiCode() {
        return this.henJiCode;
    }

    public void setHenJiCode(String henJiCode) {
        this.henJiCode = henJiCode;
    }

    public String getXiuXingShiJian() {
        return this.xiuXingShiJian;
    }

    public void setXiuXingShiJian(String xiuXingShiJian) {
        this.xiuXingShiJian = xiuXingShiJian;
    }

    public String getBeiZhu() {
        return this.beiZhu;
    }

    public void setBeiZhu(String beiZhu) {
        this.beiZhu = beiZhu;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
