package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description><br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日 <br>
 * @see <br>
 * @since V1.0<br>
 **/
@Getter
@Setter
public class Dict extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -5465923115203175831L;

    private String id;

    private String funcId;

    private String dictName;

    private String dictCode;

    private String comments;

    private String category;

    private String modifyFlag;

    private String visiableFlag;

    private int seq;

    private String spId;

    private int version;

    private List<DictData> dictDataList;

}
