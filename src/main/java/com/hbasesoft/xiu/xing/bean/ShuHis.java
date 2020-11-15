package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description> shu_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-11 <br>
 * @since V1.0<br>
 * @see ShuHis <br>
 */
@Getter
@Setter
public class ShuHis extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1901115245584570064L;

    /** ID */
    private String id;

    /** shu_id */
    private String shuId;

    /** shu_code */
    private String shuCode;

    /** shu_name */
    private String shuName;

    /** shu_state */
    private String shuState;

    private String shuStateName;

    /** shu_fen_lei */
    private String shuFenLei;

    private String shuFenLeiName;

    /** shu_jing_jie_id */
    private String shuJingJieId;

    private String shuJingJieName;

    /** shu_pin_ji_id */
    private String shuPinJiId;

    private String shuPinJiName;

    /** shu_xiu_xing */
    private String shuXiuXing;

    /** shu_miao_shu */
    private String shuMiaoShu;

    /** addr_id */
    private String addrId;

    private String addrFullName;

    /** update_time */
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    private List<String> fullNames;

    private List<String> addrIds;

}
