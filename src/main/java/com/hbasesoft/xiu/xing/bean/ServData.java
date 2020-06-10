package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> serv_data的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-26 <br>
 * @since V1.0<br>
 * @see ServData <br>
 */
@Getter
@Setter
public class ServData extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3544334475827676664L;

    /** ID */
    private String id;

    /** serv_id */
    private String servId;

    /** datasource_id */
    private String datasourceId;

    /** action */
    private String action;

    /** data_script */
    private String dataScript;

}
