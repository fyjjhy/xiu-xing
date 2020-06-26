package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.SuoShuDao;
import com.hbasesoft.xiu.xing.entity.SuoShuEntity;
import com.hbasesoft.xiu.xing.service.SuoShuService;
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
public class SuoShuServiceImpl implements SuoShuService {

    @Resource
    private SuoShuDao suoShuDao;

    @Override
    public SuoShuEntity getSuoShuById(String suoShuId) {
        return suoShuDao.get(SuoShuEntity.class, suoShuId);
    }

    @Override
    public void updateSuoShu(SuoShuEntity suoShuEntity) {
        suoShuDao.updateEntity(suoShuEntity);
    }

    @Override
    public String saveSuoShu(SuoShuEntity suoShuEntity) {
        return (String) suoShuDao.save(suoShuEntity);
    }

    @Override
    public int getSuoShuCount() {
        return suoShuDao.getSuoShuCount();
    }
}
