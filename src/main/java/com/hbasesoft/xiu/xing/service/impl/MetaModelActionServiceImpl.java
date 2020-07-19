package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.MetaModelActionDao;
import com.hbasesoft.xiu.xing.entity.MetaModelActionEntity;
import com.hbasesoft.xiu.xing.service.MetaModelActionService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月30日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class MetaModelActionServiceImpl implements MetaModelActionService {

    @Resource
    private MetaModelActionDao metaModelActionDao;

    @Override
    public List<MetaModelActionEntity> queryMetaModelActionByModelId(String metaModelId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MetaModelActionEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.MODEL_ID, metaModelId));
        criteria.addOrder(Order.asc(XiuXingCommonConstant.SEQ));
        return metaModelActionDao.getListByCriteriaQuery(criteria);
    }
}
