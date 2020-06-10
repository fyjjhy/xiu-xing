package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> datasource的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-26 <br>
 * @since V1.0<br>
 * @see Datasource <br>
 */
@Getter
@Setter
public class Datasource extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6138576953715272741L;

    /** ID */
    private String id;

    /** code */
    private String code;

    /** url */
    private String url;

    /** name */
    private String name;

    /** password */
    private String password;

    /** remark */
    private String remark;

}
