package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> dict_data的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-30 <br>
 * @since V1.0<br>
 * @see DictDataEntity <br>
 */
@Entity
@Table(name = "dict_data")
public class DictDataEntity extends BaseEntity {

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

    /** dict_id */
    @Column(name = "dict_id")
    private String dictId;

    /** data_code */
    @Column(name = "data_code")
    private String dataCode;

    /** data_name */
    @Column(name = "data_name")
    private String dataName;

    /** seq */
    @Column(name = "seq")
    private Integer seq;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictId() {
        return this.dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDataCode() {
        return this.dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public String getDataName() {
        return this.dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

}
