package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <Description><br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-10-11 <br>
 * @since V1.0<br>
 * @see CongShuInfo <br>
 */
@Getter
@Setter
public class CongShuInfo extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1901115245584570064L;

    /** congShuHisId */
    private String congShuHisId;

    /** congShuId */
    private String congShuId;

    /** congShuName */
    private String congShuName;

    /** congShuState */
    private String congShuState;

    /** congShuStateName */
    private String congShuStateName;

    /** congShuShuXing */
    private String congShuShuXing;

    /** congShuFenLei */
    private String congShuFenLei;

    /** congShuFenLeiName */
    private String congShuFenLeiName;

    /** congShuJingJieId */
    private String congShuJingJieId;

    /** congShuJingJieName */
    private String congShuJingJieName;

    /** congShuPinJiId */
    private String congShuPinJiId;

    /** congShuPinJiName */
    private String congShuPinJiName;

    /** congShuXiuXing */
    private String congShuXiuXing;

    /** congShuMiaoShu */
    private String congShuMiaoShu;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    /** xiaoShuoName */
    private String xiaoShuoName;

    private List<String> fullNames;

    private List<String> addrIds;

    /** congShuType */
    private String congShuType;

    /** cangKuHisId */
    private String cangKuHisId;

    /** addrFullName */
    private String addrFullName;

    /** zhangJieId */
    private String zhangJieId;

    /** zhangJieTitle */
    private String zhangJieTitle;

}
