package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.framework.common.GlobalConstants;
import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.xiu.xing.api.ShengChengApi;
import com.hbasesoft.xiu.xing.service.ConfigItemService;
import com.hbasesoft.xiu.xing.service.ShengChengService;
import com.hbasesoft.xiu.xing.service.ZiDianService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
public class ShengChengController implements ShengChengApi {

    @Resource
    private ShengChengService shengChengService;

    @Resource
    private ConfigItemService configItemService;

    @Resource
    private ZiDianService ziDianService;

    @Override
    public List<String> queryAddress(@RequestBody Map<String, Object> data) {
        LoggerUtil.info("生成入参：{0}", data);
        List<String> shengChengList = new ArrayList<>();
        if (MapUtils.isNotEmpty(data) && data.containsKey("shengChengName")) {
            // 关键字集合
            List<String> keywords = new ArrayList<>();
            // 生成长度
            int shengChengChangDu = 3;
            int shengChengShuLiang = 10;
            String shengChengWeiZhi = "zhong";
            List<String> shengChengZiJiList = new ArrayList<>();
            // 是否使用配置项
            if (data.containsKey("configItem")) {
                if (GlobalConstants.YES.equals(data.get("configItem"))) {
                    String shengChengName = configItemService.getConfigItem("shengCheng", (String) data.get("shengChengName"));
                    keywords.addAll(Arrays.asList(shengChengName.split("、")));
                }
                else if(data.containsKey("keyword")) {
                    String keyword = (String) data.get("keyword");
                    keywords.addAll(Arrays.asList(keyword.split("、")));
                }
            }

            // 字级
            if (data.containsKey("ziJi")) {
                List<String> ziJiList = (List<String>) data.get("ziJi");
                shengChengZiJiList.addAll(ziJiList);
            }

            // 位置
            if (data.containsKey("weiZhi")) {
                shengChengWeiZhi = (String) data.get("weiZhi");
            }

            // 长度
            String changDu = (String) data.get("changDu");
            if (StringUtils.isNotEmpty(changDu) && Integer.parseInt(changDu) > 0) {
                shengChengChangDu = Integer.parseInt(changDu);
            }

            // 数量
            if (data.containsKey("shuLiang")) {
                String shuLiang = (String) data.get("shuLiang");
                shengChengShuLiang = Integer.parseInt(shuLiang);
            }

            // 查询字典收录字数
            int ziDianCount = ziDianService.getZiDianCount();
            Random rand = new Random();
            for (int i = 0; i < shengChengShuLiang; i++) {
                while (true) {
                    List<String> codes = new ArrayList<>();
                    for (int j = 0; j < shengChengChangDu; j++) {
                        int code =rand.nextInt(ziDianCount) + 1;
                        codes.add(String.valueOf(code));
                    }
                    // 获取指定文字
                    List<String> ziNameList = ziDianService.getZiDianList(codes, shengChengZiJiList);
                    if (CollectionUtils.isNotEmpty(ziNameList)) {
                        String name =  String.join(GlobalConstants.BLANK, ziNameList);
                        for (String keyword : keywords) {
                            if ("shou".equals(shengChengWeiZhi)) {
                                shengChengList.add(keyword + name);
                            }
                            else if ("wei".equals(shengChengWeiZhi)) {
                                shengChengList.add(name + keyword);
                            }
                            else if ("zhong".equals(shengChengWeiZhi) && !(StringUtils.startsWith(name, keyword) || StringUtils.endsWith(name, keyword))) {
                                shengChengList.add(name);
                            }
                        }
                        break;
                    }
                }
            }
        }
        return shengChengList;
    }
}
