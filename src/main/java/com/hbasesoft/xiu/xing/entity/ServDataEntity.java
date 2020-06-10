package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> serv_data的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-26 <br>
 * @since V1.0<br>
 * @see ServDataEntity <br>
 */
@Entity
@Table(name = "serv_data")
public class ServDataEntity extends BaseEntity {

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

    /** serv_id */
    @Column(name = "serv_id")
    private String servId;

    /** datasource_id */
    @Column(name = "datasource_id")
    private String datasourceId;

    /** action */
    @Column(name = "action")
    private String action;

    /** data_script */
    @Column(name = "data_script")
    private String dataScript;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServId() {
        return this.servId;
    }

    public void setServId(String servId) {
        this.servId = servId;
    }

    public String getDatasourceId() {
        return this.datasourceId;
    }

    public void setDatasourceId(String datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDataScript() {
        return this.dataScript;
    }

    public void setDataScript(String dataScript) {
        this.dataScript = dataScript;
    }

}
