package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> ling_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-26 <br>
 * @since V1.0<br>
 * @see LingWu <br>
 */
@Getter
@Setter
public class LingWu extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8967001515659068185L;

    /** ID */
    private String id;

    /** ling_wu_name */
    private String lingWuName;

    /** ling_wu_fen_lei */
    private String lingWuFenLei;

    /** ling_wu_id */
    private String lingWuId;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
