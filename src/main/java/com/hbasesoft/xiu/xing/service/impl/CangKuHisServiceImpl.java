package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.CangKuHisDao;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class CangKuHisServiceImpl implements CangKuHisService {

    @Resource
    private CangKuHisDao cangKuHisDao;

    @Override
    public String saveOrUpdateCangKuHis(CangKuHisEntity hisEntity) {
        return (String) cangKuHisDao.save(hisEntity);
    }

    @Override
    public List<CangKuHisEntity> queryCangKuHisByCongShu(String congShuId) {
        return cangKuHisDao.queryCangKuHisByCongShu(congShuId);
    }

    @Override
    public void syncLingWuSuoShuHisId(String xiaoShuoId) {
//        DetachedCriteria criteria = DetachedCriteria.forClass(CangKuEntity.class);
//        criteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//        List<CangKuEntity> cangKuEntityList = cangKuHisDao.getListByCriteriaQuery(criteria);
//        if (CollectionUtils.isNotEmpty(cangKuEntityList)) {
//            for (CangKuEntity cangKuEntity : cangKuEntityList) {
//                DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LingWuHisEntity.class);
//                if (cangKuEntity.getLingWuFenLei() != null) {
//                    detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_FEN_LEI, cangKuEntity.getLingWuFenLei()));
//                }
//                else {
//                    detachedCriteria.add(Restrictions.isNull(XiuXingCommonConstant.LING_WU_FEN_LEI));
//                }
//                if (cangKuEntity.getLingWuMiaoShu() != null) {
//                    detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_MIAO_SHU, cangKuEntity.getLingWuMiaoShu()));
//                }
//                else {
//                    detachedCriteria.add(Restrictions.isNull(XiuXingCommonConstant.LING_WU_MIAO_SHU));
//                }
//                detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_NAME, cangKuEntity.getLingWuName()));
//                detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//                LingWuHisEntity lingWuHisEntity = cangKuHisDao.getCriteriaQuery(detachedCriteria);
//                if (lingWuHisEntity != null) {
//                    cangKuEntity.setLingWuHisId(lingWuHisEntity.getId());
//                }
//
//                DetachedCriteria suoShuCriteria = DetachedCriteria.forClass(SuoShuHisEntity.class);
//                if (cangKuEntity.getSuoShuFenLei() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_FEN_LEI, cangKuEntity.getSuoShuFenLei()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SUO_SHU_FEN_LEI));
//                }
//                if (cangKuEntity.getSuoShuMiaoShu() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, cangKuEntity.getSuoShuMiaoShu()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SUO_SHU_MIAO_SHU));
//                }
//                if (cangKuEntity.getAddrId() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.ADDR_ID, cangKuEntity.getAddrId()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.ADDR_ID));
//                }
//                suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_NAME, cangKuEntity.getSuoShuName()));
//                suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//                SuoShuHisEntity suoShuHisEntity = cangKuHisDao.getCriteriaQuery(suoShuCriteria);
//                if (suoShuHisEntity != null) {
//                    cangKuEntity.setSuoShuId(suoShuHisEntity.getSuoShuId());
//                    cangKuEntity.setSuoShuHisId(suoShuHisEntity.getId());
//                }
//                cangKuHisDao.updateEntity(cangKuEntity);
//            }
//        }
//
//        DetachedCriteria cangKuHisCriteria = DetachedCriteria.forClass(CangKuHisEntity.class);
//        cangKuHisCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//        List<CangKuHisEntity> cangKuHisEntityList = cangKuHisDao.getListByCriteriaQuery(cangKuHisCriteria);
//        if (CollectionUtils.isNotEmpty(cangKuHisEntityList)) {
//            for (CangKuHisEntity cangKuHisEntity : cangKuHisEntityList) {
//                DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LingWuHisEntity.class);
//                if (cangKuHisEntity.getLingWuFenLei() != null) {
//                    detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_FEN_LEI, cangKuHisEntity.getLingWuFenLei()));
//                }
//                else {
//                    detachedCriteria.add(Restrictions.isNull(XiuXingCommonConstant.LING_WU_FEN_LEI));
//                }
//                if (cangKuHisEntity.getLingWuMiaoShu() != null) {
//                    detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_MIAO_SHU, cangKuHisEntity.getLingWuMiaoShu()));
//                }
//                else {
//                    detachedCriteria.add(Restrictions.isNull(XiuXingCommonConstant.LING_WU_MIAO_SHU));
//                }
//                detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.LING_WU_NAME, cangKuHisEntity.getLingWuName()));
//                detachedCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//                LingWuHisEntity lingWuHisEntity = cangKuHisDao.getCriteriaQuery(detachedCriteria);
//                if (lingWuHisEntity != null) {
//                    cangKuHisEntity.setLingWuHisId(lingWuHisEntity.getId());
//                }
//
//                DetachedCriteria suoShuCriteria = DetachedCriteria.forClass(SuoShuHisEntity.class);
//                if (cangKuHisEntity.getSuoShuFenLei() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_FEN_LEI, cangKuHisEntity.getSuoShuFenLei()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SUO_SHU_FEN_LEI));
//                }
//                if (cangKuHisEntity.getSuoShuMiaoShu() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_MIAO_SHU, cangKuHisEntity.getSuoShuMiaoShu()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.SUO_SHU_MIAO_SHU));
//                }
//                if (cangKuHisEntity.getAddrId() != null) {
//                    suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.ADDR_ID, cangKuHisEntity.getAddrId()));
//                }
//                else {
//                    suoShuCriteria.add(Restrictions.isNull(XiuXingCommonConstant.ADDR_ID));
//                }
//                suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.SUO_SHU_NAME, cangKuHisEntity.getSuoShuName()));
//                suoShuCriteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, xiaoShuoId));
//                SuoShuHisEntity suoShuHisEntity = cangKuHisDao.getCriteriaQuery(suoShuCriteria);
//                if (suoShuHisEntity != null) {
//                    cangKuHisEntity.setSuoShuId(suoShuHisEntity.getSuoShuId());
//                    cangKuHisEntity.setSuoShuHisId(suoShuHisEntity.getId());
//                }
//                cangKuHisDao.updateEntity(cangKuHisEntity);
//            }
//        }

    }

    @Override
    public int updateCangKuHisByCongShuId(String origin, String target) {
        return cangKuHisDao.updateCangKuHisByCongShuId(origin, target);
    }

    @Override
    public int updateCangKuHisByCongShuHisId(String congHisId, String congId) {
        return cangKuHisDao.updateCangKuHisByCongShuHisId(congHisId, congId);
    }

    @Override
    public CangKuHisEntity getCangKuHis(String cangKuHisId) {
        return cangKuHisDao.get(CangKuHisEntity.class, cangKuHisId);
    }
}
