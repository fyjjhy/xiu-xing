package com.hbasesoft.xiu.xing.entity;

import com.hbasesoft.framework.db.core.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <Description> process的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-28 <br>
 * @since V1.0<br>
 * @see ProcessEntity <br>
 */
@Entity
@Table(name = "process")
public class ProcessEntity extends BaseEntity {

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

    /** process_name */
    @Column(name = "process_name")
    private String processName;

    /** process_code */
    @Column(name = "process_code")
    private String processCode;

    /** state */
    @Column(name = "state")
    private String state;

    /** state_time */
    @Column(name = "state_time")
    private java.util.Date stateTime;

    /** content */
    @Column(name = "content")
    private String content;

    /** comments */
    @Column(name = "comments")
    private String comments;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessCode() {
        return this.processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public java.util.Date getStateTime() {
        return this.stateTime;
    }

    public void setStateTime(java.util.Date stateTime) {
        this.stateTime = stateTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
