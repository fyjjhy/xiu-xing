package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.FenLeiDao;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.service.FenLeiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月05日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class FenLeiServiceImpl implements FenLeiService {

    @Resource
    private FenLeiDao fenLeiDao;

    @Override
    public int getFenLeiCount() {
        return fenLeiDao.getFenLeiDao();
    }

    @Override
    public FenLeiEntity getFenLei(String fenLeiId) {
        return fenLeiDao.get(FenLeiEntity.class, fenLeiId);
    }
}
