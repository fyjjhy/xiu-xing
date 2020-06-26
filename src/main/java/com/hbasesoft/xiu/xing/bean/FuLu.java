package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * <Description> fu_lu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-15 <br>
 * @since V1.0<br>
 * @see FuLu <br>
 */
@Getter
@Setter
public class FuLu extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3760910353379179831L;


    /** ID */
    private String id;

    /** fu_lu_code */
    private String fuLuCode;

    /** fu_lu_name */
    private String fuLuName;

    /** fu_lu_miao_shu */
    private String fuLuMiaoShu;

    /** fu_lu_shu_xing */
    private String fuLuShuXing;

    /** fu_lu_fen_lei */
    private String fuLuFenLei;

    /** update_time */
    private String updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuLu fuLu = (FuLu) o;
        return Objects.equals(fuLuName, fuLu.fuLuName) &&
                Objects.equals(fuLuMiaoShu, fuLu.fuLuMiaoShu) &&
                Objects.equals(fuLuShuXing, fuLu.fuLuShuXing) &&
                Objects.equals(xiaoShuoId, fuLu.xiaoShuoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fuLuName, fuLuMiaoShu, fuLuShuXing, xiaoShuoId);
    }
}
