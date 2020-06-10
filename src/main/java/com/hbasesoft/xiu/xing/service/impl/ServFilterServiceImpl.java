package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.framework.common.utils.CommonUtil;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ServiceFilterDao;
import com.hbasesoft.xiu.xing.entity.ServFilterEntity;
import com.hbasesoft.xiu.xing.service.ServFilterService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月26日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@Service
public class ServFilterServiceImpl implements ServFilterService {

    @Resource
    private ServiceFilterDao serviceFilterDao;

    @Override
    public List<ServFilterEntity> queryServFilter(String category, String servCode, String action) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ServFilterEntity.class);
        detachedCriteria.addOrder(Order.asc(XiuXingCommonConstant.SEQ));
        List<ServFilterEntity> entityList = serviceFilterDao.getListByCriteriaQuery(detachedCriteria);
        if (CollectionUtils.isEmpty(entityList)) {
            return entityList;
        }
        String code = category + "/" + servCode;
        // 过滤掉服务
        return entityList.stream().filter(entity -> {
            return CommonUtil.match(entity.getServCodes(), code) && CommonUtil.match(entity.getServActions(), action);
        }).collect(Collectors.toList());
    }
}
