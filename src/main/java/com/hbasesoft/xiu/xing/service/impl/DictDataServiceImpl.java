package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.DictDataDao;
import com.hbasesoft.xiu.xing.entity.DictDataEntity;
import com.hbasesoft.xiu.xing.service.DictDataService;
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
public class DictDataServiceImpl implements DictDataService {

    @Resource
    private DictDataDao dictDataDao;

    @Override
    public List<DictDataEntity> queryDictDataByDictId(String dictId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DictDataEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.DICT_ID, dictId));
        return dictDataDao.getListByCriteriaQuery(criteria);
    }
}
