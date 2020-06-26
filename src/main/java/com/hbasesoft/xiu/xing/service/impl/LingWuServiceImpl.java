package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.LingWu;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.LingWuDao;
import com.hbasesoft.xiu.xing.entity.LingWuEntity;
import com.hbasesoft.xiu.xing.service.LingWuService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
public class LingWuServiceImpl implements LingWuService {

    @Resource
    private LingWuDao lingWuDao;

    @Override
    public LingWuEntity getLingWuByInfo(LingWu lingWu) {
        DetachedCriteria criteria = DetachedCriteria.forClass(LingWuEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_ID, lingWu.getLingWuId()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_FEN_LEI, lingWu.getLingWuFenLei()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, lingWu.getXiaoShuoId()));
        return lingWuDao.getCriteriaQuery(criteria);
    }

    @Override
    public void updateLingWu(LingWuEntity lingWuEntity) {
        lingWuDao.updateEntity(lingWuEntity);
    }

    @Override
    public String saveLingWu(LingWuEntity lingWuEntity) {
        return (String) lingWuDao.save(lingWuEntity);
    }

    @Override
    public LingWuEntity getLingWuById(String lingWuId) {
        return lingWuDao.get(LingWuEntity.class, lingWuId);
    }

    @Override
    public int getLingWuCount() {
        return lingWuDao.getLingWuCount();
    }
}
