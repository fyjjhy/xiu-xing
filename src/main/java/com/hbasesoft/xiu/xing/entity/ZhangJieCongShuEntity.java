package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> zhang_jie_cong_shu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-17 <br>
 * @since V1.0<br>
 * @see ZhangJieCongShuEntity <br>
 */
@Entity
@Table(name = "zhang_jie_cong_shu")
public class ZhangJieCongShuEntity extends BaseEntity {

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

    /** type */
    @Column(name = "type")
    private String type;

    /** cong_shu_his_id */
    @Column(name = "cong_shu_his_id")
    private String congShuHisId;

    /** cong_shu_id */
    @Column(name = "cong_shu_id")
    private String congShuId;

    /** zhang_jie_id */
    @Column(name = "zhang_jie_id")
    private String zhangJieId;

    /** xiao_shuo_id */
    @Column(name = "xiao_shuo_id")
    private String xiaoShuoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCongShuHisId() {
        return this.congShuHisId;
    }

    public void setCongShuHisId(String congShuHisId) {
        this.congShuHisId = congShuHisId;
    }

    public String getCongShuId() {
        return this.congShuId;
    }

    public void setCongShuId(String congShuId) {
        this.congShuId = congShuId;
    }

    public String getZhangJieId() {
        return this.zhangJieId;
    }

    public void setZhangJieId(String zhangJieId) {
        this.zhangJieId = zhangJieId;
    }

    public String getXiaoShuoId() {
        return this.xiaoShuoId;
    }

    public void setXiaoShuoId(String xiaoShuoId) {
        this.xiaoShuoId = xiaoShuoId;
    }

}
