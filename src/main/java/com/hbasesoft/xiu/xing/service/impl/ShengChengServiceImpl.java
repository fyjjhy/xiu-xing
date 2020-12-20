package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ShengChengDao;
import com.hbasesoft.xiu.xing.service.ShengChengService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月21日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ShengChengServiceImpl implements ShengChengService {

    @Resource
    private ShengChengDao shengChengDao;

    @Override
    public int getShengChengCount() {
        return shengChengDao.getShengChengCount();
    }
}
