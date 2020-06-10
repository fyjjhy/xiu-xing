package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日 <br>
 * @since V1.0<br>
 * @see <br>
 */
@Getter
@Setter
public class FuncMetaData extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 2040131936010279645L;

    private String id;

    private String icon;

    private String funcCode;

    private String funcName;

    private String state;

    private String comments;

    private String stateTime;

    private int seq;

    private String indexUrl;

    private List<Dict> dictList;

    private List<ConfigItem> configList;

    private List<FuncComponent> funcComponentList;

    private List<MetaModel> metaModelList;

}
