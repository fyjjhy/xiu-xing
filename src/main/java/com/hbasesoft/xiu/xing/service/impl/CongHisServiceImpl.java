package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.CongHis;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.CongHisDao;
import com.hbasesoft.xiu.xing.dao.FenLeiDao;
import com.hbasesoft.xiu.xing.entity.CongHisEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.service.CongHisService;
import com.hbasesoft.xiu.xing.util.BeanTransferUtil;
import com.hbasesoft.xiu.xing.util.GlobalConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class CongHisServiceImpl implements CongHisService {

    @Resource
    private CongHisDao congHisDao;

    @Resource
    private FenLeiDao fenLeiDao;

    @Override
    public String saveOrUpdateCongHis(CongHisEntity congHisEntity) {
        DetachedCriteria congCriteria = DetachedCriteria.forClass(CongHisEntity.class);
        if (StringUtils.isNotEmpty(congHisEntity.getCongMiaoShu())) {
            congCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_MIAO_SHU, congHisEntity.getCongMiaoShu()));
        }
        else {
            congCriteria.add(Restrictions.isNull(XiuXingCommonConstant.CONG_MIAO_SHU));
        }
        congCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_NAME, congHisEntity.getCongName()));
        congCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_CODE, congHisEntity.getCongCode()));
        congCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_FEN_LEI, congHisEntity.getCongFenLei()));
        congCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_ID, congHisEntity.getCongId()));
        if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
            congCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, congHisEntity.getXiaoShuoId()));
        }
        else {
            congCriteria.add(Restrictions.isNull(XiuXingCommonConstant.XIAO_SHUO_ID));
        }
        List<CongHisEntity> congHisEntityList = congHisDao.getListByCriteriaQuery(congCriteria);
        if (CollectionUtils.isEmpty(congHisEntityList)) {
            return (String) congHisDao.save(congHisEntity);
        }
        return congHisEntityList.get(0).getId();
    }

    @Override
    public String saveCongHis(CongHisEntity congHisEntity) {
        return (String) congHisDao.save(congHisEntity);
    }

    @Override
    public List<CongHisEntity> getCongHisList(CongHisEntity congHisEntity) {
        DetachedCriteria congHisCriteria = DetachedCriteria.forClass(CongHisEntity.class);
        if (StringUtils.isNotEmpty(congHisEntity.getCongMiaoShu())) {
            congHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_MIAO_SHU, congHisEntity.getCongMiaoShu()));
        }
        else {
            congHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.CONG_MIAO_SHU));
        }
        congHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_NAME, congHisEntity.getCongName()));
        congHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_FEN_LEI, congHisEntity.getCongFenLei()));
        if (StringUtils.isNotEmpty(congHisEntity.getXiaoShuoId())) {
            congHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, congHisEntity.getXiaoShuoId()));
        }
        else {
            congHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.XIAO_SHUO_ID));
        }
        return congHisDao.getListByCriteriaQuery(congHisCriteria);
    }

    @Override
    public List<CongHisEntity> getCongHisList(String congId) {
        return congHisDao.findByProperty(CongHisEntity.class, XiuXingCommonConstant.CONG_ID, congId);
    }

    @Override
    public CongHisEntity getCongHis(String congHisId) {
        return congHisDao.get(CongHisEntity.class, congHisId);
    }

    @Override
    public List<CongHis> getCongHisListById(String congHisIds) {
        DetachedCriteria criteria = DetachedCriteria.forClass(CongHisEntity.class);
        criteria.add(Restrictions.in(XiuXingCommonConstant.ID, congHisIds.split(GlobalConstants.SPLITOR)));
        criteria.addOrder(Order.desc(XiuXingCommonConstant.CONG_ID));
        List<CongHisEntity> congHisEntityList = congHisDao.getListByCriteriaQuery(criteria);
        if (CollectionUtils.isNotEmpty(congHisEntityList)) {
            return BeanTransferUtil.mapList(congHisEntityList, congHisEntity -> {
                CongHis congHis = new CongHis();
                BeanUtils.copyProperties(congHisEntity, congHis);
                if (StringUtils.isNotEmpty(congHisEntity.getCongFenLei())) {
                    FenLeiEntity fenLeiEntity = fenLeiDao.get(FenLeiEntity.class, congHisEntity.getCongFenLei());
                    if (fenLeiEntity != null) {
                        congHis.setCongFenLeiName(fenLeiEntity.getFenLeiName());
                    }
                }
                return congHis;
            });
        }
        return new ArrayList<>();
    }

    @Override
    public int updateCongHisById(CongHisEntity congHisEntity) {
        return congHisDao.updateCongHisById(congHisEntity);
    }
}
