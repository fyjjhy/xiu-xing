package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description> cong_his的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-11 <br>
 * @since V1.0<br>
 * @see CongHis <br>
 */
@Getter
@Setter
public class CongHis extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4622549990205640393L;

    /** ID */
    private String id;

    /** cong_id */
    private String congId;

    /** cong_code */
    private String congCode;

    /** cong_name */
    private String congName;

    /** cong_fen_lei */
    private String congFenLei;

    private String congFenLeiName;

    /** cong_miao_shu */
    private String congMiaoShu;

    /** update_time */
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    private String addrFullName;

    private String congStateName;

    private String congJingJieName;

    private String congPinJiName;

    private List<String> fullNames;

    private List<String> addrIds;

    private String congShuXing;

    private String congState;

    private String congJingJiId;

    private String congPinJiId;

    private String congXiuXing;

}
