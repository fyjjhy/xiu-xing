package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日<br>
 * @see <br>
 * @since V1.0<br>
 **/
@Getter
@Setter
public class ConfigItem extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 6939362583022420501L;

    private String id;

    private String category;

    private String funcId;

    private String configName;

    private String configCode;

    private String configValue;

    private String defaultValue;

    private int version;

    private String modifyFlag;

    private String visiableFlag;

    private String valueType;

    private String displayType;

    private String comments;

    private String validateRule;

    private String valueList;

    private int seq;

    private String spId;

}
