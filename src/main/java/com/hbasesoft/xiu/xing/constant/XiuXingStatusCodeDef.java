package com.hbasesoft.xiu.xing.constant;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.constant <br>
 * @since V1.0 <br>
 */
public interface XiuXingStatusCodeDef {

    /** 正常状态 */
    String AVAILABLE = "A";

    /** */
    String BACK = "B";

    /** 完成 */
    String FINISH = "C";

    /** 失败、错误、已关闭 */
    String ERROR = "E";

    /** 初始化 */
    String INIT = "I";

    /** 进行中 */
    String PROGRESS = "P";

    /** 锁定、处理中 */
    String LOCK = "L";

    /** 开通中 */
    String OPERATE = "O";

    /** 删除 */
    String DISABLE = "X";

}
