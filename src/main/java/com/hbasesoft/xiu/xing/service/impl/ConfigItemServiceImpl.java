package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.framework.common.GlobalConstants;
import com.hbasesoft.xiu.xing.constant.XiuXingCommonConstant;
import com.hbasesoft.xiu.xing.dao.ConfigItemDao;
import com.hbasesoft.xiu.xing.entity.ConfigItemEntity;
import com.hbasesoft.xiu.xing.service.ConfigItemService;
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
public class ConfigItemServiceImpl implements ConfigItemService {

    @Resource
    private ConfigItemDao configItemDao;

    @Override
    public List<ConfigItemEntity> queryConfItems(String funcId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(ConfigItemEntity.class);
        criteria.add(Restrictions.eq(XiuXingCommonConstant.FUNC_ID, funcId));
        return configItemDao.getListByCriteriaQuery(criteria);
    }

    @Override
    public String getConfigItem(String funcCode, String configCode) {
        ConfigItemEntity entity = configItemDao.getConfigItem(funcCode, configCode);
        return entity == null ? GlobalConstants.BLANK : entity.getConfigValue();
    }

}
