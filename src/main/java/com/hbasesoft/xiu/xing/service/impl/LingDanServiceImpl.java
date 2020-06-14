package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.LingDanDao;
import com.hbasesoft.xiu.xing.service.LingDanService;
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
public class LingDanServiceImpl implements LingDanService {

    @Resource
    private LingDanDao lingDanDao;

    @Override
    public int getLingDanCount() {
        return lingDanDao.getLingDanCount();
    }
}
