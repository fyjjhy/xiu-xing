package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.GongFaDao;
import com.hbasesoft.xiu.xing.service.GongFaService;
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
public class GongFaServiceImpl implements GongFaService {

    @Resource
    private GongFaDao gongFaDao;

    @Override
    public int getGongFaCount() {
        return gongFaDao.getGongFaCount();
    }
}
