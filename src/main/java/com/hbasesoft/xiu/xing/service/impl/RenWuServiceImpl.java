package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.RenWuDao;
import com.hbasesoft.xiu.xing.entity.RenWuEntity;
import com.hbasesoft.xiu.xing.service.RenWuService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class RenWuServiceImpl implements RenWuService {

    @Resource
    private RenWuDao renWuDao;

    @Override
    public Object queryRenWu() {
        DetachedCriteria criteria = DetachedCriteria.forClass(RenWuEntity.class);
        return renWuDao.getListByCriteriaQuery(criteria);
    }

    @Override
    public int getRenWuCount() {
        return renWuDao.getRenWuCount();
    }
}
