package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingStatusCodeDef;
import com.hbasesoft.xiu.xing.dao.DictDao;
import com.hbasesoft.xiu.xing.entity.DictEntity;
import com.hbasesoft.xiu.xing.service.DictService;
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
 * @CreateDate 2020年05月30日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictDao dictDao;

    @Override
    public List<DictEntity> queryDictByFuncId(String funcId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DictEntity.class);
        criteria.add(Restrictions.ne(XiuXingCommonConstant.STATE, XiuXingStatusCodeDef.DISABLE));
        criteria.add(Restrictions.eq(XiuXingCommonConstant.FUNC_ID, funcId));
        return dictDao.getListByCriteriaQuery(criteria);
    }
}
