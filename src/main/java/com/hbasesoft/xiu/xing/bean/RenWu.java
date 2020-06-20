package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.xiu.xing.util.AbstractVo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * <Description> ren_wu的Entity<br>
 * 
 * @author 工具生成<br>
 * @version 1.0<br>
 * @CreateDate 2020-06-20 <br>
 * @since V1.0<br>
 * @see RenWu <br>
 */
@Getter
@Setter
public class RenWu extends AbstractVo {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** ren_wu_code */
    private String renWuCode;

    /** ren_wu_name */
    private String renWuName;

    /** ceng_yong_ming */
    private String cengYongMing;

    /** ren_wu_fen_lei */
    private String renWuFenLei;

    /** ren_wu_state */
    private String renWuState;

    /** ren_wu_shu_xing */
    private String renWuShuXing;

    /** ren_wu_miao_shu */
    private String renWuMiaoShu;

    /** di_tu_id */
    private String diTuId;

    /** update_time */
    private java.util.Date updateTime;

    /** xiao_shuo_id */
    private String xiaoShuoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RenWu renWu = (RenWu) o;
        return Objects.equals(renWuCode, renWu.renWuCode) &&
                Objects.equals(renWuName, renWu.renWuName) &&
                Objects.equals(renWuFenLei, renWu.renWuFenLei) &&
                Objects.equals(renWuState, renWu.renWuState) &&
                Objects.equals(renWuShuXing, renWu.renWuShuXing) &&
                Objects.equals(renWuMiaoShu, renWu.renWuMiaoShu) &&
                Objects.equals(xiaoShuoId, renWu.xiaoShuoId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(renWuCode, renWuName, renWuFenLei, renWuState, renWuShuXing, renWuMiaoShu, xiaoShuoId);
    }
}
