/**************************************************************************************** 
 Copyright © 2003-2012 hbasesoft Corporation. All rights reserved. Reproduction or       <br>
 transmission in whole or in part, in any form or by any means, electronic, mechanical <br>
 or otherwise, is prohibited without the prior written consent of the copyright owner. <br>
 ****************************************************************************************/
package com.hbasesoft.xiu.xing.util;

/**
 * <Description> 传递分页参数<br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年1月24日 <br>
 * @since V1.0<br>
 * @see SortPager <br>
 */
public class SortPager extends AbstractVo {

    /**
     * serialVersionUID <br>
     */
    private static final long serialVersionUID = 3608478733515385385L;

    private int pageIndex = 1;

    private int pageSize = 20;

    private String[] asc;

    private String[] desc;

    /** 
     *  
     */
    public SortPager() {
        super();
    }

    /**
     * @param pageIndex
     * @param pageSize
     */
    public SortPager(int pageIndex, int pageSize) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    /**
     * @param pageIndex
     * @param pageSize
     * @param asc
     * @param desc
     */
    public SortPager(int pageIndex, int pageSize, String[] asc, String[] desc) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.asc = asc;
        this.desc = desc;
    }

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

    public String[] getAsc() {
        return asc;
    }

    public void setAsc(String[] asc) {
        this.asc = asc;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }
}
