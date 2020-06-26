package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.QiTaLingWuDao;
import com.hbasesoft.xiu.xing.entity.QiTaLingWuEntity;
import com.hbasesoft.xiu.xing.service.QiTaLingWuService;
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
public class QiTaLingWuServiceImpl implements QiTaLingWuService {

    @Resource
    private QiTaLingWuDao qiTaLingWuDao;

    @Override
    public int getQiTaLingWuCount() {
        return qiTaLingWuDao.getQiTaLingWuCount();
    }

    @Override
    public QiTaLingWuEntity getQiTaLingWuById(String qiTaLingWuId) {
        return qiTaLingWuDao.get(QiTaLingWuEntity.class, qiTaLingWuId);
    }

    @Override
    public void updateQiTaLingWu(QiTaLingWuEntity qiTaLingWuEntity) {
        qiTaLingWuDao.updateEntity(qiTaLingWuEntity);
    }
}
