package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.framework.common.utils.logger.LoggerUtil;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ZhangJieCongShuDao;
import com.hbasesoft.xiu.xing.entity.ZhangJieCongShuEntity;
import com.hbasesoft.xiu.xing.service.ZhangJieCongShuService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
 * @CreateDate 2020年10月17日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ZhangJieCongShuServiceImpl implements ZhangJieCongShuService {

    private static final int COMMIT_NUMBER = 100;

    @Resource
    private ZhangJieCongShuDao zhangJieCongShuDao;

    @Override
    public int delZhangJieCongShuByZhangJieId(String zhangJieId) {
        return zhangJieCongShuDao.delZhangJieCongShuByZhangJieId(zhangJieId);
    }

    @Override
    public int delEmptyZhangJieCongShu(String zhangJieId) {
        return zhangJieCongShuDao.delEmptyZhangJieCongShu(zhangJieId);
    }

    @Override
    public void saveZhangJieCongShu(List<ZhangJieCongShuEntity> zhangJieCongShuEntityList) {
        LoggerUtil.info("开始处理 zhang_jie_cong_shu 数据，总共{0}条", zhangJieCongShuEntityList.size());
        try {

            List<Object[]> saveObjs = new ArrayList<>();
            for (ZhangJieCongShuEntity entity : zhangJieCongShuEntityList) {
                saveObjs.add(new Object[]{
                        entity.getId(), entity.getType(), entity.getCongShuHisId(), entity.getCongShuId(),
                        entity.getZhangJieId(), entity.getXiaoShuoId()
                });
            }
            if (CollectionUtils.isNotEmpty(saveObjs)) {
                LoggerUtil.info("正在批量保存 zhang_jie_cong_shu 的数据, 总共{0}条。", saveObjs.size());

                String sql = "INSERT INTO zhang_jie_cong_shu (id, type, cong_shu_his_id, cong_shu_id, zhang_jie_id, xiao_shuo_id)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?)";
                zhangJieCongShuDao.batchExecute(sql, saveObjs, COMMIT_NUMBER);
                LoggerUtil.info("保存 zhang_jie_cong_shu 的数据成功, 总共{0}条。", saveObjs.size());
            }
        }
        catch (Exception e) {
            LoggerUtil.error(e);
            throw e;
        }
    }

    @Override
    public void saveZhangJieCongShu(ZhangJieCongShuEntity zhangJieCongShuEntity) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ZhangJieCongShuEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.TYPE, zhangJieCongShuEntity.getType()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_HIS_ID, zhangJieCongShuEntity.getCongShuHisId()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.CONG_SHU_ID, zhangJieCongShuEntity.getCongShuId()));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.ZHANG_JIE_ID, zhangJieCongShuEntity.getZhangJieId()));
        if (StringUtils.isNotEmpty(zhangJieCongShuEntity.getXiaoShuoId())) {
            criteria.add(Restrictions.eq(XiuXingCommonConstant.XIAO_SHUO_ID, zhangJieCongShuEntity.getXiaoShuoId()));
        }
        else {
            criteria.add(Restrictions.isNull(XiuXingCommonConstant.XIAO_SHUO_ID));
        }
        List<ZhangJieCongShuEntity> zhangJieCongShuEntityList = zhangJieCongShuDao.getListByCriteriaQuery(criteria);
        if (CollectionUtils.isEmpty(zhangJieCongShuEntityList)) {
            zhangJieCongShuDao.save(zhangJieCongShuEntity);
        }
    }

    @Override
    public int updateZhangJieCongShuByCongShuHisId(String congHisId, String congId) {
        return zhangJieCongShuDao.updateZhangJieCongShuByCongShuHisId(congHisId, congId);
    }
}
