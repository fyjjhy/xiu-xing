package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> suo_shu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see SuoShuEntity <br>
 */
@Entity
@Table(name = "suo_shu")
public class SuoShuEntity extends BaseEntity {

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

    /** suo_shu_fen_lei */
    @Column(name = "suo_shu_fen_lei")
    private String suoShuFenLei;

    /** suo_shu_name */
    @Column(name = "suo_shu_name")
    private String suoShuName;

    /** suo_shu_id */
    @Column(name = "suo_shu_id")
    private String suoShuId;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuoShuFenLei() {
        return this.suoShuFenLei;
    }

    public void setSuoShuFenLei(String suoShuFenLei) {
        this.suoShuFenLei = suoShuFenLei;
    }

    public String getSuoShuName() {
        return this.suoShuName;
    }

    public void setSuoShuName(String suoShuName) {
        this.suoShuName = suoShuName;
    }

    public String getSuoShuId() {
        return this.suoShuId;
    }

    public void setSuoShuId(String suoShuId) {
        this.suoShuId = suoShuId;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
