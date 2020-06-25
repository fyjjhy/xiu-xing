package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.LingCaiDao;
import com.hbasesoft.xiu.xing.entity.LingCaiEntity;
import com.hbasesoft.xiu.xing.service.LingCaiService;
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
public class LingCaiServiceImpl implements LingCaiService {

    @Resource
    private LingCaiDao lingCaiDao;

    @Override
    public int getLingCaiCount() {
        return lingCaiDao.getLingCaiCount();
    }

    @Override
    public LingCaiEntity getLingCaiById(String lingCaiId) {
        return lingCaiDao.get(LingCaiEntity.class, lingCaiId);
    }
}
