package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ShuDao;
import com.hbasesoft.xiu.xing.entity.ShuEntity;
import com.hbasesoft.xiu.xing.service.ShuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ShuServiceImpl implements ShuService {

    @Resource
    private ShuDao shuDao;

    @Override
    public ShuEntity getShuById(String shuId) {
        return shuDao.get(ShuEntity.class, shuId);
    }

    @Override
    public void updateShu(ShuEntity shuEntity) {
        shuDao.updateEntity(shuEntity);
    }

    @Override
    public String saveShu(ShuEntity shuEntity) {
        return (String) shuDao.save(shuEntity);
    }

    @Override
    public int getShuCount() {
        return shuDao.getShuCount();
    }

    @Override
    public void delShuById(String shuId) {
        shuDao.deleteEntityById(ShuEntity.class, shuId);
    }
}
