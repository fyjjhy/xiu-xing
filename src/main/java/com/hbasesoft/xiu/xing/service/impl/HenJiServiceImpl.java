package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.HenJiDao;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.service.HenJiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年09月06日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class HenJiServiceImpl implements HenJiService {

    @Resource
    private HenJiDao henJiDao;

    @Override
    public int getHenJiCount() {
        return henJiDao.getHenJiCount();
    }

    @Override
    public HenJiEntity getHenJi(String henJiId) {
        return henJiDao.get(HenJiEntity.class, henJiId);
    }

    @Override
    public String saveHenJi(HenJiEntity henJiEntity) {
        return (String) henJiDao.save(henJiEntity);
    }
}
