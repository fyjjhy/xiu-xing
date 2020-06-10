package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.MetaModelDao;
import com.hbasesoft.xiu.xing.entity.MetaModelEntity;
import com.hbasesoft.xiu.xing.service.FuncMetaDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月29日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class FuncMetaDataServiceImpl implements FuncMetaDataService {

    @Resource
    private MetaModelDao metaModelDao;

    @Override
    public List<MetaModelEntity> queryMetaModelByFuncId(String funcId) {
        return metaModelDao.queryMetaModelByFuncId(funcId);
    }
}
