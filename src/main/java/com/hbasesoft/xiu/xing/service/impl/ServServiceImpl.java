package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.Serv;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingStatusCodeDef;
import com.hbasesoft.xiu.xing.dao.ServDao;
import com.hbasesoft.xiu.xing.entity.ServEntity;
import com.hbasesoft.xiu.xing.service.ServService;
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
 * @CreateDate 2020年05月24日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@Service
public class ServServiceImpl implements ServService {

    @Resource
    private ServDao servDao;

    @Override
    public Serv getServiceByCategoryAndServCode(String category, String servCode) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ServEntity.class);
        detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.CATEGORY, category));
        detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.SERV_CODE, servCode));
        detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.STATE, XiuXingStatusCodeDef.AVAILABLE));
        ServEntity servEntity = servDao.getCriteriaQuery(detachedCriteria);
        Serv serv = null;
        if (servEntity != null) {
            serv = new Serv();
            BeanUtils.copyProperties(servEntity, serv);
        }
        return serv;
    }
}
