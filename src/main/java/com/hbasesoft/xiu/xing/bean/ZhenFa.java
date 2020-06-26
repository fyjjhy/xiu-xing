package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> zhen_fa的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-25 <br>
 * @since V1.0<br>
 * @see ZhenFa <br>
 */
@Getter
@Setter
public class ZhenFa extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8316492748843355592L;

    /** ID */
    private String id;

    /** zhen_fa_code */
    private String zhenFaCode;

    /** zhen_fa_name */
    private String zhenFaName;

    /** zhen_fa_shu_xing */
    private String zhenFaShuXing;

    /** zhen_fa_miao_shu */
    private String zhenFaMiaoShu;

    /** update_time */
    private String updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
