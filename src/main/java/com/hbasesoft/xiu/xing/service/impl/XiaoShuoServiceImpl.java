package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.XiaoShuoDao;
import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import com.hbasesoft.xiu.xing.service.XiaoShuoService;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月07日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class XiaoShuoServiceImpl implements XiaoShuoService {

    @Resource
    private XiaoShuoDao xiaoShuoDao;

    @Override
    public XiaoShuoEntity getXiaoShuo(String xiaoShuoId) {
        return xiaoShuoDao.get(XiaoShuoEntity.class, xiaoShuoId);
    }

    @Override
    public XiaoShuoEntity getXiaoShuoOne() {
        DetachedCriteria criteria = DetachedCriteria.forClass(XiaoShuoEntity.class);
        criteria.addOrder(Order.desc(XiuXingCommonConstant.TOPPING_TIME));
        List<XiaoShuoEntity> entities = xiaoShuoDao.getListByCriteriaQuery(criteria);
        if (CollectionUtils.isNotEmpty(entities)) {
            return entities.get(0);
        }
        return null;
    }
}
