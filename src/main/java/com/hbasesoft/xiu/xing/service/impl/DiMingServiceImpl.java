package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.DiMingDao;
import com.hbasesoft.xiu.xing.entity.DiMingEntity;
import com.hbasesoft.xiu.xing.service.DiMingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月13日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class DiMingServiceImpl implements DiMingService {

    @Resource
    private DiMingDao diMingDao;

    @Override
    public int getDiMingCount() {
        return diMingDao.getDiMingCount();
    }

    @Override
    public DiMingEntity getDiMingById(String diMingId) {
        return diMingDao.get(DiMingEntity.class, diMingId);
    }
}
