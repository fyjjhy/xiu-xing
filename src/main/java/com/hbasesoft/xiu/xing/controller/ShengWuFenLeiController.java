package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.ShengWuFenLeiApi;
import com.hbasesoft.xiu.xing.service.ShengWuFenLeiService;
import com.hbasesoft.xiu.xing.util.SelOpt;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.controller <br>
 * @since V1.0 <br>
 */
@RestController
public class ShengWuFenLeiController implements ShengWuFenLeiApi {

    @Resource
    private ShengWuFenLeiService shengWuFenLeiService;

    @Override
    public List<SelOpt> queryShengWuFenLeiList(@RequestParam("leiBie") String leiBie) {
        return shengWuFenLeiService.queryShengWuFenLeiList(leiBie);
    }
}
