package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ProcessDao;
import com.hbasesoft.xiu.xing.entity.ProcessEntity;
import com.hbasesoft.xiu.xing.service.ProcessService;
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
 * @see <br>
 * @since V1.0 <br>
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Resource
    private ProcessDao processDao;

    @Override
    public ProcessEntity getProcess(String processCode) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ProcessEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.PROCESS_CODE, processCode));
        return processDao.getCriteriaQuery(criteria);
    }
}
