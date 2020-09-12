package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.LingWuHisDao;
import com.hbasesoft.xiu.xing.entity.LingWuHisEntity;
import com.hbasesoft.xiu.xing.service.LingWuHisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
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
 * @CreateDate 2020年07月18日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class LingWuHisServiceImpl implements LingWuHisService {

    @Resource
    private LingWuHisDao lingWuHisDao;

    @Override
    public String saveOrUpdateLingWuHis(LingWuHisEntity lingWuHisEntity) {
        DetachedCriteria lingWuCriteria = DetachedCriteria.forClass(LingWuHisEntity.class);
        if (StringUtils.isNotEmpty(lingWuHisEntity.getLingWuMiaoShu())) {
            lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_MIAO_SHU, lingWuHisEntity.getLingWuMiaoShu()));
        }
        else {
            lingWuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.LING_WU_MIAO_SHU));
        }
        if (StringUtils.isNotEmpty(lingWuHisEntity.getXiuXingSuiYue())) {
            lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIU_XING_SUI_YUE, lingWuHisEntity.getXiuXingSuiYue()));
        }
        else {
            lingWuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.XIU_XING_SUI_YUE));
        }
        lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_NAME, lingWuHisEntity.getLingWuName()));
        lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_CODE, lingWuHisEntity.getLingWuCode()));
        lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_FEN_LEI, lingWuHisEntity.getLingWuFenLei()));
        lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_ID, lingWuHisEntity.getLingWuId()));
        lingWuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, lingWuHisEntity.getXiaoShuoId()));
        List<LingWuHisEntity> lingWuHisEntityList = lingWuHisDao.getListByCriteriaQuery(lingWuCriteria);
        if (CollectionUtils.isEmpty(lingWuHisEntityList)) {
            return (String) lingWuHisDao.save(lingWuHisEntity);
        }
        return lingWuHisEntityList.get(0).getId();
    }

    @Override
    public List<LingWuHisEntity> getLingWuHisList(String lingWuId) {
        return lingWuHisDao.findByProperty(LingWuHisEntity.class, XiuXingCommonConstant.LING_WU_ID, lingWuId);
    }

    @Override
    public LingWuHisEntity getLingWuHis(String lingWuHisId) {
        return lingWuHisDao.get(LingWuHisEntity.class, lingWuHisId);
    }
}
