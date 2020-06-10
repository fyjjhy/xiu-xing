package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.ServData;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ServDataDao;
import com.hbasesoft.xiu.xing.entity.ServDataEntity;
import com.hbasesoft.xiu.xing.service.ServDataService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@Service
public class ServDataServiceImpl implements ServDataService {

    @Resource
    private ServDataDao servDataDao;

    @Override
    public ServData getServiceDataEntityByServId(String servId, String action) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ServDataEntity.class);
        detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.ACTION, action));
        detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.SERV_ID, servId));
        ServDataEntity servDataEntity = servDataDao.getCriteriaQuery(detachedCriteria);
        ServData servData = null;
        if (servDataEntity != null) {
            servData = new ServData();
            BeanUtils.copyProperties(servDataEntity, servData);
        }
        return servData;
    }
}
