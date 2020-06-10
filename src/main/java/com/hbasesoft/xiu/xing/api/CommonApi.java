package com.hbasesoft.xiu.xing.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月24日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@RequestMapping("/common")
public interface CommonApi {

    /**
     * Description: 查询列表数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param data
     * @return <br>
     */
    @GetMapping("/{category}/{servCode}")
    <T> T query(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                @RequestParam Map<String, Object> data);

    /**
     * Description: 获取单条记录<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param resId
     * @return <br>
     */
    @GetMapping("/{category}/{servCode}/{resId}")
    <T> T get(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
              @PathVariable("resId") String resId);

    /**
     * Description: 新增数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param data
     * @return <br>
     */
    @PostMapping("/{category}/{servCode}")
    <T> T add(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
              @RequestBody Map<String, Object> data);

    /**
     * Description: 修改数据,以提交数据为主<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param resId
     * @param data
     * @return <br>
     */
    @PutMapping("/{category}/{servCode}/{resId}")
    <T> T update(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                 @PathVariable("resId") String resId, @RequestBody Map<String, Object> data);

    /**
     * Description: 修改数据，只修改部分字段<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param resId
     * @param data
     * @return <br>
     */
    @PatchMapping("/{category}/{servCode}/{resId}")
    <T> T modify(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                 @PathVariable("resId") String resId, @RequestBody Map<String, Object> data);

    /**
     * Description: 删除数据<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param resId
     * @return <br>
     */
    @DeleteMapping("/{category}/{servCode}/{resId}")
    void delete(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                @PathVariable("resId") String resId);

    /**
     * Description: 其他扩展的方法<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param category
     * @param servCode
     * @param action
     * @param data
     * @return <br>
     */
    @PostMapping("/{category}/{servCode}/{action}")
    <T> T action(@PathVariable("category") String category, @PathVariable("servCode") String servCode,
                 @PathVariable("action") String action, @RequestBody Map<String, Object> data);

}
