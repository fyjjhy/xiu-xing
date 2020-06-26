package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.FaShuDao;
import com.hbasesoft.xiu.xing.entity.FaShuEntity;
import com.hbasesoft.xiu.xing.service.FaShuService;
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
public class FaShuServiceImpl implements FaShuService {

    @Resource
    private FaShuDao faShuDao;

    @Override
    public int getFaShuCount() {
        return faShuDao.getFaShuCount();
    }

    @Override
    public FaShuEntity getFaShuById(String faShuId) {
        return faShuDao.get(FaShuEntity.class, faShuId);
    }

    @Override
    public void updateFaShu(FaShuEntity faShuEntity) {
        faShuDao.updateEntity(faShuEntity);
    }
}
