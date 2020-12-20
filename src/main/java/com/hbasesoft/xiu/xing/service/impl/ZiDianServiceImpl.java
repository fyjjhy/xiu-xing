package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ZiDianDao;
import com.hbasesoft.xiu.xing.entity.ZiDianEntity;
import com.hbasesoft.xiu.xing.service.ZiDianService;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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
 * @CreateDate 2020年11月21日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ZiDianServiceImpl implements ZiDianService {

    @Resource
    private ZiDianDao ziDianDao;

    @Override
    public int getZiDianCount() {
        return ziDianDao.getZiDianCount();
    }

    @Override
    public List<String> getZiDianList(List<String> ziDianIds, List<String> ziJiList) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ZiDianEntity.class);
        criteria.add(Restrictions.in(XiuXingCommonConstant.ID, ziDianIds));
        if (CollectionUtils.isNotEmpty(ziJiList)) {
            criteria.add(Restrictions.in(XiuXingCommonConstant.ZI_JI, ziJiList));
        }
        ProjectionList pList = Projections.projectionList();
        pList.add(Projections.property(XiuXingCommonConstant.ZI_NAME));
        criteria.setProjection(pList);
        return ziDianDao.getListByCriteriaQuery(criteria);
    }
}
