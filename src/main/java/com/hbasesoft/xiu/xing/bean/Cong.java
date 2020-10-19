package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

/**
 * <Description> cong的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-26 <br>
 * @since V1.0<br>
 * @see Cong <br>
 */
@Getter
@Setter
public class Cong extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8967001515659068185L;

    /** ID */
    private String id;

    /** cong_name */
    private String congName;

    /** cong_fen_lei */
    private String congFenLei;

    /** cong_id */
    private String congId;

    /** xiao_shuo_id */
    private String xiaoShuoId;

}
