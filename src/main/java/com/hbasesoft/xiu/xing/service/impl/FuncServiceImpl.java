package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.constant.XiuXingStatusCodeDef;
import com.hbasesoft.xiu.xing.dao.FuncDao;
import com.hbasesoft.xiu.xing.entity.FuncEntity;
import com.hbasesoft.xiu.xing.service.FuncService;
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
 * @CreateDate 2020年05月28日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class FuncServiceImpl implements FuncService {

    @Resource
    private FuncDao funcDao;

    @Override
    public FuncEntity getFuncByFuncCode(String funcCode) {
        DetachedCriteria criteria = DetachedCriteria.forClass(FuncEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.FUNC_CODE, funcCode));
        criteria.add(Restrictions.ne(XiuXingCommonConstant.STATE, XiuXingStatusCodeDef.DISABLE));
        return funcDao.getCriteriaQuery(criteria);
    }
}
