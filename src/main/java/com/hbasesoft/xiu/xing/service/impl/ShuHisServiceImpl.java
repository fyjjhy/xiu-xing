package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.ShuHis;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.AddressDao;
import com.hbasesoft.xiu.xing.dao.FenLeiDao;
import com.hbasesoft.xiu.xing.dao.JingJieDao;
import com.hbasesoft.xiu.xing.dao.PinJiDao;
import com.hbasesoft.xiu.xing.dao.ShuHisDao;
import com.hbasesoft.xiu.xing.entity.AddressEntity;
import com.hbasesoft.xiu.xing.entity.FenLeiEntity;
import com.hbasesoft.xiu.xing.entity.JingJieEntity;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.entity.ShuHisEntity;
import com.hbasesoft.xiu.xing.service.ShuHisService;
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
public class ShuHisServiceImpl implements ShuHisService {

    @Resource
    private ShuHisDao shuHisDao;

    @Resource
    private FenLeiDao fenLeiDao;

    @Resource
    private JingJieDao jingJieDao;

    @Resource
    private PinJiDao pinJiDao;

    @Resource
    private AddressDao addressDao;

    @Override
    public String saveOrUpdateShuHis(ShuHisEntity shuHisEntity) {
        DetachedCriteria shuHisCriteria = DetachedCriteria.forClass(ShuHisEntity.class);
        if (StringUtils.isNotEmpty(shuHisEntity.getShuMiaoShu())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_MIAO_SHU, shuHisEntity.getShuMiaoShu()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_MIAO_SHU));
        }
//        if (StringUtils.isNotEmpty(shuHisEntity.getAddrId())) {
//            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.ADDR_ID, shuHisEntity.getAddrId()));
//        }
//        else {
//            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.ADDR_ID));
//        }
        if (StringUtils.isNotEmpty(shuHisEntity.getShuFenLei())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_FEN_LEI, shuHisEntity.getShuFenLei()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_FEN_LEI));
        }
        if (StringUtils.isNotEmpty(shuHisEntity.getShuState())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_STATE, shuHisEntity.getShuState()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_STATE));
        }
        if (StringUtils.isNotEmpty(shuHisEntity.getShuJingJieId())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_JING_JIE_ID, shuHisEntity.getShuJingJieId()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_JING_JIE_ID));
        }
        if (StringUtils.isNotEmpty(shuHisEntity.getShuPinJiId())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_PIN_JI_ID, shuHisEntity.getShuPinJiId()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_PIN_JI_ID));
        }
        if (StringUtils.isNotEmpty(shuHisEntity.getShuXiuXing())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_XIU_XING, shuHisEntity.getShuXiuXing()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_XIU_XING));
        }
        shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_NAME, shuHisEntity.getShuName()));
        shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_CODE, shuHisEntity.getShuCode()));
        shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_ID, shuHisEntity.getShuId()));
        if (StringUtils.isNotEmpty(shuHisEntity.getXiaoShuoId())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, shuHisEntity.getXiaoShuoId()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.XIAO_SHUO_ID));
        }
        List<ShuHisEntity> shuHisEntityList = shuHisDao.getListByCriteriaQuery(shuHisCriteria);
        if (CollectionUtils.isEmpty(shuHisEntityList)) {
            return (String) shuHisDao.save(shuHisEntity);
        }
        return shuHisEntityList.get(0).getId();
    }

    @Override
    public String saveShuHis(ShuHisEntity shuHisEntity) {
        return (String) shuHisDao.save(shuHisEntity);
    }

    @Override
    public List<ShuHisEntity> getShuHisList(String shuId) {
        return shuHisDao.findByProperty(ShuHisEntity.class, XiuXingCommonConstant.SHU_ID, shuId);
    }

    @Override
    public List<ShuHisEntity> getShuHisList(ShuHisEntity shuHisEntity) {
        DetachedCriteria shuHisCriteria = DetachedCriteria.forClass(ShuHisEntity.class);
        if (StringUtils.isNotEmpty(shuHisEntity.getShuMiaoShu())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_MIAO_SHU, shuHisEntity.getShuMiaoShu()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SHU_MIAO_SHU));
        }
        shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_NAME, shuHisEntity.getShuName()));
        shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.SHU_FEN_LEI, shuHisEntity.getShuFenLei()));
        if (StringUtils.isNotEmpty(shuHisEntity.getXiaoShuoId())) {
            shuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, shuHisEntity.getXiaoShuoId()));
        }
        else {
            shuHisCriteria.add(Restrictions.isNull(XiuXingCommonConstant.XIAO_SHUO_ID));
        }
        return shuHisDao.getListByCriteriaQuery(shuHisCriteria);
    }

    @Override
    public List<ShuHis> getShuHisListById(String shuHisIds) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ShuHisEntity.class);
        criteria.add(Restrictions.in(XiuXingCommonConstant.ID, shuHisIds.split(GlobalConstants.SPLITOR)));
        criteria.addOrder(Order.desc(XiuXingCommonConstant.SHU_ID));
        List<ShuHisEntity> shuHisEntityList = shuHisDao.getListByCriteriaQuery(criteria);
        if (CollectionUtils.isNotEmpty(shuHisEntityList)) {
            return BeanTransferUtil.mapList(shuHisEntityList, shuHisEntity -> {
                ShuHis shuHis = new ShuHis();
                BeanUtils.copyProperties(shuHisEntity, shuHis);
                if (StringUtils.isNotEmpty(shuHisEntity.getShuFenLei())) {
                    FenLeiEntity fenLeiEntity = fenLeiDao.get(FenLeiEntity.class, shuHisEntity.getShuFenLei());
                    if (fenLeiEntity != null) {
                        shuHis.setShuFenLeiName(fenLeiEntity.getFenLeiName());
                    }
                }

                if (StringUtils.isNotEmpty(shuHisEntity.getShuJingJieId())) {
                    JingJieEntity jingJieEntity = jingJieDao.get(JingJieEntity.class, shuHisEntity.getShuJingJieId());
                    if (jingJieEntity != null) {
                        shuHis.setShuJingJieName(jingJieEntity.getJingJieName());
                    }
                }

                if (StringUtils.isNotEmpty(shuHisEntity.getShuPinJiId())) {
                    PinJiEntity pinJiEntity = pinJiDao.get(PinJiEntity.class, shuHisEntity.getShuPinJiId());
                    if (pinJiEntity != null) {
                        shuHis.setShuPinJiName(pinJiEntity.getPinJiName());
                    }
                }

                if (StringUtils.isNotEmpty(shuHisEntity.getAddrId())) {
                    AddressEntity addressEntity = addressDao.get(AddressEntity.class, shuHisEntity.getAddrId());
                    if (addressEntity != null) {
                        shuHis.setAddrFullName(addressEntity.getFullName());
                    }
                }
                return shuHis;
            });
        }
        return new ArrayList<>();
    }

    @Override
    public ShuHisEntity getShuHis(String shuHisId) {
        return shuHisDao.get(ShuHisEntity.class, shuHisId);
    }
}
