package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> kui_lei的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see KuiLei <br>
 */
@Getter
@Setter
public class KuiLei extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -650998760543570229L;

    /** ID */
    private String id;

    /** kui_lei_code */
    private String kuiLeiCode;

    /** kui_lei_name */
    private String kuiLeiName;

    /** kui_lei_shu_xing */
    private String kuiLeiShuXing;

    /** kui_lei_fen_lei */
    private String kuiLeiFenLei;

    /** kui_lei_miao_shu */
    private String kuiLeiMiaoShu;

    /** update_time */
    private String updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
