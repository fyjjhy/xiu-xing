package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> sheng_wu_fen_lei的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-11-15 <br>
 * @since V1.0<br>
 * @see ShengWuFenLeiEntity <br>
 */
@Entity
@Table(name = "sheng_wu_fen_lei")
public class ShengWuFenLeiEntity extends BaseEntity {

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

    /** code */
    @Column(name = "code")
    private String code;

    /** yu */
    @Column(name = "yu")
    private String yu;

    /** jie */
    @Column(name = "jie")
    private String jie;

    /** ya_jie */
    @Column(name = "ya_jie")
    private String yaJie;

    /** men */
    @Column(name = "men")
    private String men;

    /** ya_men */
    @Column(name = "ya_men")
    private String yaMen;

    /** gang */
    @Column(name = "gang")
    private String gang;

    /** ya_gang */
    @Column(name = "ya_gang")
    private String yaGang;

    /** zong_mu */
    @Column(name = "zong_mu")
    private String zongMu;

    /** mu */
    @Column(name = "mu")
    private String mu;

    /** ke */
    @Column(name = "ke")
    private String ke;

    /** shu */
    @Column(name = "shu")
    private String shu;

    /** zhong */
    @Column(name = "zhong")
    private String zhong;

    /** comments */
    @Column(name = "comments")
    private String comments;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getYu() {
        return this.yu;
    }

    public void setYu(String yu) {
        this.yu = yu;
    }

    public String getJie() {
        return this.jie;
    }

    public void setJie(String jie) {
        this.jie = jie;
    }

    public String getYaJie() {
        return this.yaJie;
    }

    public void setYaJie(String yaJie) {
        this.yaJie = yaJie;
    }

    public String getMen() {
        return this.men;
    }

    public void setMen(String men) {
        this.men = men;
    }

    public String getYaMen() {
        return this.yaMen;
    }

    public void setYaMen(String yaMen) {
        this.yaMen = yaMen;
    }

    public String getGang() {
        return this.gang;
    }

    public void setGang(String gang) {
        this.gang = gang;
    }

    public String getYaGang() {
        return this.yaGang;
    }

    public void setYaGang(String yaGang) {
        this.yaGang = yaGang;
    }

    public String getZongMu() {
        return this.zongMu;
    }

    public void setZongMu(String zongMu) {
        this.zongMu = zongMu;
    }

    public String getMu() {
        return this.mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public String getKe() {
        return this.ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getShu() {
        return this.shu;
    }

    public void setShu(String shu) {
        this.shu = shu;
    }

    public String getZhong() {
        return this.zhong;
    }

    public void setZhong(String zhong) {
        this.zhong = zhong;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
