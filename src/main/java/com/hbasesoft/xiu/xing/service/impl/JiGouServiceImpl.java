package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.JiGouDao;
import com.hbasesoft.xiu.xing.entity.JiGouEntity;
import com.hbasesoft.xiu.xing.service.JiGouService;
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
public class JiGouServiceImpl implements JiGouService {

    @Resource
    private JiGouDao jiGouDao;

    @Override
    public int getJiGouCount() {
        return jiGouDao.getJiGouCount();
    }

    @Override
    public JiGouEntity getJiGouById(String jiGouId) {
        return jiGouDao.get(JiGouEntity.class, jiGouId);
    }

    @Override
    public void updateJiGou(JiGouEntity jiGouEntity) {
        jiGouDao.updateEntity(jiGouEntity);
    }
}
