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
 * @CreateDate 2020-12-05 <br>
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

    /** ya_zhong */
    @Column(name = "ya_zhong")
    private String yaZhong;

    /** zhong */
    @Column(name = "zhong")
    private String zhong;

    /** ya_shu */
    @Column(name = "ya_shu")
    private String yaShu;

    /** shu */
    @Column(name = "shu")
    private String shu;

    /** ya_ke */
    @Column(name = "ya_ke")
    private String yaKe;

    /** ke */
    @Column(name = "ke")
    private String ke;

    /** zong_ke */
    @Column(name = "zong_ke")
    private String zongKe;

    /** ya_mu */
    @Column(name = "ya_mu")
    private String yaMu;

    /** mu */
    @Column(name = "mu")
    private String mu;

    /** zong_mu */
    @Column(name = "zong_mu")
    private String zongMu;

    /** ya_gang */
    @Column(name = "ya_gang")
    private String yaGang;

    /** gang */
    @Column(name = "gang")
    private String gang;

    /** zong_gang */
    @Column(name = "zong_gang")
    private String zongGang;

    /** ya_men */
    @Column(name = "ya_men")
    private String yaMen;

    /** men */
    @Column(name = "men")
    private String men;

    /** zong_men */
    @Column(name = "zong_men")
    private String zongMen;

    /** ya_jie */
    @Column(name = "ya_jie")
    private String yaJie;

    /** jie */
    @Column(name = "jie")
    private String jie;

    /** yu */
    @Column(name = "yu")
    private String yu;

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

    public String getYaZhong() {
        return this.yaZhong;
    }

    public void setYaZhong(String yaZhong) {
        this.yaZhong = yaZhong;
    }

    public String getZhong() {
        return this.zhong;
    }

    public void setZhong(String zhong) {
        this.zhong = zhong;
    }

    public String getYaShu() {
        return this.yaShu;
    }

    public void setYaShu(String yaShu) {
        this.yaShu = yaShu;
    }

    public String getShu() {
        return this.shu;
    }

    public void setShu(String shu) {
        this.shu = shu;
    }

    public String getYaKe() {
        return this.yaKe;
    }

    public void setYaKe(String yaKe) {
        this.yaKe = yaKe;
    }

    public String getKe() {
        return this.ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getZongKe() {
        return this.zongKe;
    }

    public void setZongKe(String zongKe) {
        this.zongKe = zongKe;
    }

    public String getYaMu() {
        return this.yaMu;
    }

    public void setYaMu(String yaMu) {
        this.yaMu = yaMu;
    }

    public String getMu() {
        return this.mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public String getZongMu() {
        return this.zongMu;
    }

    public void setZongMu(String zongMu) {
        this.zongMu = zongMu;
    }

    public String getYaGang() {
        return this.yaGang;
    }

    public void setYaGang(String yaGang) {
        this.yaGang = yaGang;
    }

    public String getGang() {
        return this.gang;
    }

    public void setGang(String gang) {
        this.gang = gang;
    }

    public String getZongGang() {
        return this.zongGang;
    }

    public void setZongGang(String zongGang) {
        this.zongGang = zongGang;
    }

    public String getYaMen() {
        return this.yaMen;
    }

    public void setYaMen(String yaMen) {
        this.yaMen = yaMen;
    }

    public String getMen() {
        return this.men;
    }

    public void setMen(String men) {
        this.men = men;
    }

    public String getZongMen() {
        return this.zongMen;
    }

    public void setZongMen(String zongMen) {
        this.zongMen = zongMen;
    }

    public String getYaJie() {
        return this.yaJie;
    }

    public void setYaJie(String yaJie) {
        this.yaJie = yaJie;
    }

    public String getJie() {
        return this.jie;
    }

    public void setJie(String jie) {
        this.jie = jie;
    }

    public String getYu() {
        return this.yu;
    }

    public void setYu(String yu) {
        this.yu = yu;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
