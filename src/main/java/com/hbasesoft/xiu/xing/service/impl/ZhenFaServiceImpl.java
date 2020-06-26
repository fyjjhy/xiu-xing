package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ZhenFaDao;
import com.hbasesoft.xiu.xing.entity.ZhenFaEntity;
import com.hbasesoft.xiu.xing.service.ZhenFaService;
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
public class ZhenFaServiceImpl implements ZhenFaService {

    @Resource
    private ZhenFaDao zhenFaDao;

    @Override
    public int getZhenFaCount() {
        return zhenFaDao.getZhenFaCount();
    }

    @Override
    public ZhenFaEntity getZhenFaById(String zhenFaId) {
        return zhenFaDao.get(ZhenFaEntity.class, zhenFaId);
    }

    @Override
    public void updateZhenFa(ZhenFaEntity entity) {
        zhenFaDao.updateEntity(entity);
    }
}
