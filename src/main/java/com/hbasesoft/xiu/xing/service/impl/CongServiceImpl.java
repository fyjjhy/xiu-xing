package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.bean.Cong;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.CongDao;
import com.hbasesoft.xiu.xing.entity.CongEntity;
import com.hbasesoft.xiu.xing.service.CongService;
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
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class CongServiceImpl implements CongService {

    @Resource
    private CongDao congDao;

    @Override
    public CongEntity getCongByInfo(Cong cong) {
        DetachedCriteria criteria = DetachedCriteria.forClass(CongEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.ID, cong.getCongId()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_FEN_LEI, cong.getCongFenLei()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, cong.getXiaoShuoId()));
        return congDao.getCriteriaQuery(criteria);
    }

    @Override
    public void updateCong(CongEntity congEntity) {
        congDao.updateEntity(congEntity);
    }

    @Override
    public String saveCong(CongEntity congEntity) {
        return (String) congDao.save(congEntity);
    }

    @Override
    public CongEntity getCongById(String congId) {
        return congDao.get(CongEntity.class, congId);
    }

    @Override
    public int getCongCount() {
        return congDao.getCongCount();
    }
}
