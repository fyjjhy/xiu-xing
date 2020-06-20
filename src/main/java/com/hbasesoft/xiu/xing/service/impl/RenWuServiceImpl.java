package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.RenWu;
import com.hbasesoft.xiu.xing.dao.RenWuDao;
import com.hbasesoft.xiu.xing.entity.RenWuEntity;
import com.hbasesoft.xiu.xing.entity.RenWuHisEntity;
import com.hbasesoft.xiu.xing.service.RenWuService;
import com.hbasesoft.xiu.xing.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeanUtils;
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

    @Override
    public int getRenWuHisCount(String lingWuId) {
        return renWuDao.getRenWuHisCount(lingWuId);
    }

    @Override
    public RenWuEntity saveOrUpdate(RenWu renWu) {
        RenWuEntity entity = new RenWuEntity();
        BeanUtils.copyProperties(renWu, entity);
        entity.setUpdateTime(DateUtil.getCurrentDate());
        if (StringUtils.isEmpty(entity.getRenWuCode())) {
            int renWuCount = renWuDao.getRenWuCount();
            entity.setRenWuCode(String.valueOf(++renWuCount));
        }
        renWuDao.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public RenWuEntity getRenWuById(String lingWuId) {
        return renWuDao.get(RenWuEntity.class, lingWuId);
    }

    @Override
    public void saveRenWuHis(RenWuHisEntity hisEntity) {
        renWuDao.save(hisEntity);
    }
}
