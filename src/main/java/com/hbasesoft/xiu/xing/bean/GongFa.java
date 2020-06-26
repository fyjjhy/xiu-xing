package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * <Description> gong_fa的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see GongFa <br>
 */
@Getter
@Setter
public class GongFa extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7087271642411439148L;

    /** ID */
    private String id;

    /** gong_fa_code */
    private String gongFaCode;

    /** gong_fa_name */
    private String gongFaName;

    /** gong_fa_fen_lei */
    private String gongFaFenLei;

    /** gong_fa_shu_xing */
    private String gongFaShuXing;

    /** gong_fa_miao_shu */
    private String gongFaMiaoShu;

    /** update_time */
    private String updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GongFa gongFa = (GongFa) o;
        return Objects.equals(gongFaName, gongFa.gongFaName) &&
                Objects.equals(gongFaShuXing, gongFa.gongFaShuXing) &&
                Objects.equals(gongFaMiaoShu, gongFa.gongFaMiaoShu) &&
                Objects.equals(xiaoShuoId, gongFa.xiaoShuoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gongFaName, gongFaShuXing, gongFaMiaoShu, xiaoShuoId);
    }
}
