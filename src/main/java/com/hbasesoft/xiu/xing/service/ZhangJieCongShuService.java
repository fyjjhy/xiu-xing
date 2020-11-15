package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年10月17日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface ZhangJieCongShuService {

    /**
     * Description: 根据章节标识删除章节从属表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @return <br>
     */
    @Transactional(readOnly = true)
    int delZhangJieCongShuByZhangJieId(String zhangJieId);

    /**
     * Description: 删除章节从属空数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int delEmptyZhangJieCongShu(String zhangJieId);

    /**
     * Description: 批量保存章节从属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieCongShuEntityList
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void saveZhangJieCongShu(List<ZhangJieCongShuEntity> zhangJieCongShuEntityList);

    /**
     * Description: 保存章节从属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieCongShuEntity
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    void saveZhangJieCongShu(ZhangJieCongShuEntity zhangJieCongShuEntity);

    /**
     * Description: 更新章节从属信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param congHisId
     * @param congId
     * @return <br>
     */
    @Transactional(rollbackFor = Throwable.class)
    int updateZhangJieCongShuByCongShuHisId(String congHisId, String congId);

    /**
     * Description: 查询章节信息列表<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param zhangJieId
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<ZhangJieCongShuEntity> getZhangJieCongShuListByZhangJieId(String zhangJieId);

}
