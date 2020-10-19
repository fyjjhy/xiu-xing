package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.CongShuHisDao;
import com.hbasesoft.xiu.xing.entity.CongShuHisEntity;
import com.hbasesoft.xiu.xing.service.CongShuHisService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
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
public class CongShuHisServiceImpl implements CongShuHisService {

    @Resource
    private CongShuHisDao congShuHisDao;

    @Override
    public String saveOrUpdateCongShuHis(CongShuHisEntity congShuHisEntity) {
        DetachedCriteria congShuCriteria = DetachedCriteria.forClass(CongShuHisEntity.class);
        if (StringUtils.isNotEmpty(congShuHisEntity.getCongShuMiaoShu())) {
            congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_MIAO_SHU, congShuHisEntity.getCongShuMiaoShu()));
        }
        else {
            congShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.CONG_SHU_MIAO_SHU));
        }
        if (StringUtils.isNotEmpty(congShuHisEntity.getCongShuXiuXingTime())) {
            congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_XIU_XING_TIME, congShuHisEntity.getCongShuXiuXingTime()));
        }
        else {
            congShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.CONG_SHU_XIU_XING_TIME));
        }
        if (!XiuXingCommonConstant.CONG.equals(congShuHisEntity.getCongShuType())) {
            if (StringUtils.isNotEmpty(congShuHisEntity.getAddrId())) {
                congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.ADDR_ID, congShuHisEntity.getAddrId()));
            }
            else {
                congShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.ADDR_ID));
            }
        }
        congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_NAME, congShuHisEntity.getCongShuName()));
        congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_CODE, congShuHisEntity.getCongShuCode()));
        congShuCriteria.add(Restrictions.like(XiuXingCommonConstant.CONG_SHU_TYPE, congShuHisEntity.getCongShuType(), MatchMode.ANYWHERE));
        congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_FEN_LEI, congShuHisEntity.getCongShuFenLei()));
        congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_ID, congShuHisEntity.getCongShuId()));
        congShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, congShuHisEntity.getXiaoShuoId()));
        List<CongShuHisEntity> congShuHisEntityList = congShuHisDao.getListByCriteriaQuery(congShuCriteria);
        if (CollectionUtils.isEmpty(congShuHisEntityList)) {
            return (String) congShuHisDao.save(congShuHisEntity);
        }
        return congShuHisEntityList.get(0).getId();
    }

    @Override
    public List<CongShuHisEntity> getCongShuHisList(String congShuId) {
        return congShuHisDao.findByProperty(CongShuHisEntity.class, XiuXingCommonConstant.CONG_SHU_ID, congShuId);
    }

}
