package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.HenJiDao;
import com.hbasesoft.xiu.xing.entity.HenJiEntity;
import com.hbasesoft.xiu.xing.service.HenJiService;
import org.apache.commons.lang3.StringUtils;
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
 * @CreateDate 2020年09月06日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class HenJiServiceImpl implements HenJiService {

    @Resource
    private HenJiDao henJiDao;

    @Override
    public int getHenJiCount() {
        return henJiDao.getHenJiCount();
    }

    @Override
    public HenJiEntity getHenJi(String henJiId) {
        return henJiDao.get(HenJiEntity.class, henJiId);
    }

    @Override
    public String saveHenJi(HenJiEntity henJiEntity) {
        DetachedCriteria criteria = DetachedCriteria.forClass(HenJiEntity.class);
        if (StringUtils.isNotEmpty(henJiEntity.getShiJian())) {
            criteria.add(Restrictions.eq(XiuXingCommonConstant.SHI_JIAN, henJiEntity.getShiJian()));
        }
        else {
            criteria.add(Restrictions.isNull(XiuXingCommonConstant.SHI_JIAN));
        }
        if (StringUtils.isNotEmpty(henJiEntity.getBeiZhu())) {
            criteria.add(Restrictions.eq(XiuXingCommonConstant.BEI_ZHU, henJiEntity.getBeiZhu()));
        }
        else {
            criteria.add(Restrictions.isNull(XiuXingCommonConstant.BEI_ZHU));
        }
        criteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, henJiEntity.getXiaoShuoId()));
        HenJiEntity entity = henJiDao.getCriteriaQuery(criteria);
        if (entity != null) {
            return entity.getId();
        }
        int henJiCount = henJiDao.getHenJiCount();
        henJiEntity.setHenJiCode(String.valueOf(++henJiCount));
        return (String) henJiDao.save(henJiEntity);
    }
}
