package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ShengWuFenLeiDao;
import com.hbasesoft.xiu.xing.service.ShengWuFenLeiService;
import com.hbasesoft.xiu.xing.util.SelOpt;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月14日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ShengWuFenLeiServiceImpl implements ShengWuFenLeiService {

    @Resource
    private ShengWuFenLeiDao shengWuFenLeiDao;

    @Override
    public int getShengWuFenLeiCount() {
        return shengWuFenLeiDao.getShengWuFenLeiDao();
    }

    @Override
    public List<SelOpt> queryShengWuFenLeiList(String leiBie) {
        List<SelOpt> selOptList = shengWuFenLeiDao.queryShengWuFenLeiList(leiBie);
        if (CollectionUtils.isNotEmpty(selOptList)) {
            return selOptList.stream()
                    .filter(selOpt -> StringUtils.isNotEmpty(selOpt.getDataCode()) && StringUtils.isNotEmpty(selOpt.getDataName()))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
