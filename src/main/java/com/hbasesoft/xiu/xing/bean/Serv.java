package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> serv的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-05-24 <br>
 * @since V1.0<br>
 * @see Serv <br>
 */
@Getter
@Setter
public class Serv extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5053373978111523861L;


    /** ID */
    private String id;

    /** serv_code */
    private String servCode;

    /** category */
    private String category;

    /** serv_name */
    private String servName;

    /** state */
    private String state;

    /** update_time */
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
