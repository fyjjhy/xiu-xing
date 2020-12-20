package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> zi_dian的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-11-21 <br>
 * @since V1.0<br>
 * @see ZiDianEntity <br>
 */
@Entity
@Table(name = "zi_dian")
public class ZiDianEntity extends BaseEntity {

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

    /** zi_ji */
    @Column(name = "zi_ji")
    private String ziJi;

    /** pin_yin */
    @Column(name = "pin_yin")
    private String pinYin;

    /** sheng_diao */
    @Column(name = "sheng_diao")
    private Integer shengDiao;

    /** zi_name */
    @Column(name = "zi_name")
    private String ziName;

    /** xin_hua_zi_dian */
    @Column(name = "xin_hua_zi_dian")
    private String xinHuaZiDian;

    /** zu_ci_tou */
    @Column(name = "zu_ci_tou")
    private String zuCiTou;

    /** zu_ci_zhong */
    @Column(name = "zu_ci_zhong")
    private String zuCiZhong;

    /** zu_ci_wei */
    @Column(name = "zu_ci_wei")
    private String zuCiWei;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZiJi() {
        return this.ziJi;
    }

    public void setZiJi(String ziJi) {
        this.ziJi = ziJi;
    }

    public String getPinYin() {
        return this.pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    public Integer getShengDiao() {
        return this.shengDiao;
    }

    public void setShengDiao(Integer shengDiao) {
        this.shengDiao = shengDiao;
    }

    public String getZiName() {
        return this.ziName;
    }

    public void setZiName(String ziName) {
        this.ziName = ziName;
    }

    public String getXinHuaZiDian() {
        return this.xinHuaZiDian;
    }

    public void setXinHuaZiDian(String xinHuaZiDian) {
        this.xinHuaZiDian = xinHuaZiDian;
    }

    public String getZuCiTou() {
        return this.zuCiTou;
    }

    public void setZuCiTou(String zuCiTou) {
        this.zuCiTou = zuCiTou;
    }

    public String getZuCiZhong() {
        return this.zuCiZhong;
    }

    public void setZuCiZhong(String zuCiZhong) {
        this.zuCiZhong = zuCiZhong;
    }

    public String getZuCiWei() {
        return this.zuCiWei;
    }

    public void setZuCiWei(String zuCiWei) {
        this.zuCiWei = zuCiWei;
    }

}
