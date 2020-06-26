package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> yao_shou的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-13 <br>
 * @since V1.0<br>
 * @see YaoShou <br>
 */
@Getter
@Setter
public class YaoShou extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7185201640489424257L;

    /** ID */
    private String id;

    /** yao_shou_code */
    private String yaoShouCode;

    /** yao_shou_name */
    private String yaoShouName;

    /** yao_shou_fen_lei */
    private String yaoShouFenLei;

    /** yao_shou_shu_xing */
    private String yaoShouShuXing;

    /** yao_shou_miao_shu */
    private String yaoShouMiaoShu;

    /** update_time */
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
