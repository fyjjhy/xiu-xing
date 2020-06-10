package com.hbasesoft.xiu.xing.util;

import java.util.List;

/**
 * <Description> 接受分页的集合<br>
 * 
 * @author 王伟<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年1月22日 <br>
 * @since V1.0<br>
 * @see PagerListVo <br>
 */
public class PagerListVo<T> extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = -330772840442346904L;

    private int pageIndex = 1;

    private int pageSize = 10;

    private long totalSize;

    private List<T> datas;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

}
