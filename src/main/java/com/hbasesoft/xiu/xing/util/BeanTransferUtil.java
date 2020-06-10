package com.hbasesoft.xiu.xing.util;

import com.hbasesoft.framework.common.GlobalConstants;
import com.hbasesoft.framework.common.utils.Assert;
import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.framework.common.utils.bean.BeanUtil;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.framework.db.core.utils.PagerList;
import com.hbasesoft.xiu.xing.constant.XiuXingErrorCodeDef;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <Description> <br>
 * 
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月06日 <br>
 * @since V1.0<br>
 * @see <br>
 */
public final class BeanTransferUtil {

    private BeanTransferUtil() {
    }

    public static <T, R> List<R> mapList(List<T> sourceList, Function<? super T, ? extends R> targetMapper) {
        if (CollectionUtils.isNotEmpty(sourceList)) {
            return sourceList.stream().map(targetMapper).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    /**
     * Description: PagerList 转 PagerAble<br>
     * 
     * @author 付永杰<br>
     * @taskId <br>
     * @param pagerList
     * @return <br>
     */
    public static <T, R> PagerListVo<R> getPagerListVo(PagerList<T> pagerList,
        Function<? super T, ? extends R> mapper) {
        PagerListVo<R> result = new PagerListVo<>();
        if (CollectionUtils.isNotEmpty(pagerList)) {
            result.setDatas(pagerList.stream().map(mapper).collect(Collectors.toList()));
            result.setPageIndex(pagerList.getPageIndex());
            result.setPageSize(pagerList.getPageSize());
            result.setTotalSize(pagerList.getTotalCount());
        }
        else {
            if(pagerList !=null){
                result.setPageIndex(pagerList.getPageIndex());
                result.setPageSize(pagerList.getPageSize());
                result.setTotalSize(pagerList.getTotalCount());
            }  
            result.setDatas(new ArrayList<>());
        }
        return result;
    }

    public static <T> PagerListVo<T> getPagerListVo(PagerList<T> pagerList) {
        PagerListVo<T> result = new PagerListVo<>();
        result.setDatas(pagerList);
        result.setPageIndex(pagerList.getPageIndex());
        result.setPageSize(pagerList.getPageSize());
        result.setTotalSize(pagerList.getTotalCount());
        return result;
    }

    public static <T extends TreeAble> List<T> transTree(List<T> treeList) {
        List<T> resultTreeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(treeList)) {
            Map<String, TreeAble> treeMap = new HashMap<>();
            for (TreeAble tree : treeList) {
                treeMap.put(tree.getKey(), tree);
            }

            for (T tree : treeList) {
                if (StringUtils.isNotEmpty(tree.getParentKey())) {
                    TreeAble parentTree = treeMap.get(tree.getParentKey());
                    LoggerUtil.info("树形===="+tree.getKey()+"===="+tree.getParentKey());
                    Assert.notNull(parentTree, XiuXingErrorCodeDef.CANNOT_FOUND_FUNCTION_ID, tree.getParentKey());
                    List<TreeAble> children = parentTree.getChildren();
                    if (children == null) {
                        children = new ArrayList<>();
                        parentTree.setChildren(children);
                    }
                    children.add(tree);
                }
                else {
                    resultTreeList.add(tree);
                }
            }
        }
        return resultTreeList;
    }

    public static String[] filterSort(String[] sortItems, String... matchs) {
        String matchers = CommonUtil.isNotEmpty(matchs) ? StringUtils.join(matchs, GlobalConstants.SPLITOR) : null;
        return CommonUtil.isNotEmpty(sortItems)
            ? Arrays.stream(sortItems).filter(item -> matchers == null || CommonUtil.match(matchers, item))
                .map(str -> BeanUtil.camelStr2underLine(str)).collect(Collectors.toList()).toArray(new String[0])
            : sortItems;
    }

}
