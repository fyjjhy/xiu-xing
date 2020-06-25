package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.FuLuDao;
import com.hbasesoft.xiu.xing.entity.FuLuEntity;
import com.hbasesoft.xiu.xing.service.FuLuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月13日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class FuLuServiceImpl implements FuLuService {

    @Resource
    private FuLuDao fuLuDao;

    @Override
    public int getFuLuCount() {
        return fuLuDao.getFuLuCount();
    }

    @Override
    public FuLuEntity getFuLuById(String fuLuId) {
        return fuLuDao.get(FuLuEntity.class, fuLuId);
    }
}
