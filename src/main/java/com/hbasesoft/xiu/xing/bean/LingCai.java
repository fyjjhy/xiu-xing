package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * <Description> ling_cai的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-14 <br>
 * @since V1.0<br>
 * @see LingCai <br>
 */
@Getter
@Setter
public class LingCai extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2303369297562119698L;

    /** ID */
    private String id;

    /** ling_cai_code */
    private String lingCaiCode;

    /** ling_cai_name */
    private String lingCaiName;

    /** ling_cai_state */
    private String lingCaiState;

    /** ling_cai_miao_shu */
    private String lingCaiMiaoShu;

    /** ling_cai_shu_xing */
    private String lingCaiShuXing;

    /** ling_cai_fen_lei */
    private String lingCaiFenLei;

    /** update_time */
    private String updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LingCai lingCai = (LingCai) o;
        return Objects.equals(lingCaiName, lingCai.lingCaiName) &&
                Objects.equals(lingCaiMiaoShu, lingCai.lingCaiMiaoShu) &&
                Objects.equals(lingCaiShuXing, lingCai.lingCaiShuXing) &&
                Objects.equals(xiaoShuoId, lingCai.xiaoShuoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lingCaiName, lingCaiMiaoShu, lingCaiShuXing, xiaoShuoId);
    }
}
