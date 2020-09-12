package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.SuoShuHisDao;
import com.hbasesoft.xiu.xing.entity.SuoShuHisEntity;
import com.hbasesoft.xiu.xing.service.SuoShuHisService;
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
public class SuoShuHisServiceImpl implements SuoShuHisService {

    @Resource
    private SuoShuHisDao suoShuHisDao;

    @Override
    public String saveOrUpdateSuoShuHis(SuoShuHisEntity suoShuHisEntity) {
        DetachedCriteria suoShuCriteria = DetachedCriteria.forClass(SuoShuHisEntity.class);
        if (StringUtils.isNotEmpty(suoShuHisEntity.getSuoShuMiaoShu())) {
            suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, suoShuHisEntity.getSuoShuMiaoShu()));
        }
        else {
            suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SUO_SHU_MIAO_SHU));
        }
        if (StringUtils.isNotEmpty(suoShuHisEntity.getAddrId())) {
            suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.ADDR_ID, suoShuHisEntity.getAddrId()));
        }
        else {
            suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.ADDR_ID));
        }
        suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_NAME, suoShuHisEntity.getSuoShuName()));
        suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_CODE, suoShuHisEntity.getSuoShuCode()));
        suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_FEN_LEI, suoShuHisEntity.getSuoShuFenLei()));
        suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_ID, suoShuHisEntity.getSuoShuId()));
        suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, suoShuHisEntity.getXiaoShuoId()));
        List<SuoShuHisEntity> suoShuHisEntityList = suoShuHisDao.getListByCriteriaQuery(suoShuCriteria);
        if (CollectionUtils.isEmpty(suoShuHisEntityList)) {
            return (String) suoShuHisDao.save(suoShuHisEntity);
        }
        return suoShuHisEntityList.get(0).getId();
    }

    @Override
    public List<SuoShuHisEntity> getSuoShuHisList(String suoShuId) {
        return suoShuHisDao.findByProperty(SuoShuHisEntity.class, XiuXingCommonConstant.SUO_SHU_ID, suoShuId);
    }

}
