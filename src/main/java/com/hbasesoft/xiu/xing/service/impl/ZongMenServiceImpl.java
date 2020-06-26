package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ZongMenDao;
import com.hbasesoft.xiu.xing.entity.ZongMenEntity;
import com.hbasesoft.xiu.xing.service.ZongMenService;
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
public class ZongMenServiceImpl implements ZongMenService {

    @Resource
    private ZongMenDao zongMenDao;

    @Override
    public int getZongMenCount() {
        return zongMenDao.getZongMenCount();
    }

    @Override
    public ZongMenEntity getZongMenById(String zongMenId) {
        return zongMenDao.get(ZongMenEntity.class, zongMenId);
    }

    @Override
    public void updateZongMen(ZongMenEntity zongMenEntity) {
        zongMenDao.updateEntity(zongMenEntity);
    }
}
