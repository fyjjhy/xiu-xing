package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description><br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日 <br>
 * @see <br>
 * @since V1.0<br>
 **/
@Getter
@Setter
public class DictData extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 7716512028058691599L;

    private String id;

    private String dictId;

    private String dataName;

    private String dataCode;

    private int seq;

    private String spId;

    private int version;

}
