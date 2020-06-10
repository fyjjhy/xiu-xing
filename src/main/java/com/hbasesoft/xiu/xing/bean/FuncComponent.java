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
 * @CreateDate 2018年01月23日<br>
 * @see <br>
 * @since V1.0<br>
 **/
@Getter
@Setter
public class FuncComponent extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 3421416218947850231L;

    private String id;

    private String funcId;

    private String name;

    private String code;

    private String icon;

    private String displayType;

    private String comments;

}
