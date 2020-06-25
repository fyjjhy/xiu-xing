package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> ling_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see LingWuEntity <br>
 */
@Entity
@Table(name = "ling_wu")
public class LingWuEntity extends BaseEntity {

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

    /** ling_wu_name */
    @Column(name = "ling_wu_name")
    private String lingWuName;

    /** ling_wu_fen_lei */
    @Column(name = "ling_wu_fen_lei")
    private String lingWuFenLei;

    /** ling_wu_id */
    @Column(name = "ling_wu_id")
    private String lingWuId;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLingWuName() {
        return this.lingWuName;
    }

    public void setLingWuName(String lingWuName) {
        this.lingWuName = lingWuName;
    }

    public String getLingWuFenLei() {
        return this.lingWuFenLei;
    }

    public void setLingWuFenLei(String lingWuFenLei) {
        this.lingWuFenLei = lingWuFenLei;
    }

    public String getLingWuId() {
        return this.lingWuId;
    }

    public void setLingWuId(String lingWuId) {
        this.lingWuId = lingWuId;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
