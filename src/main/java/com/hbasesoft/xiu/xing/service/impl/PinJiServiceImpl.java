package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.PinJiDao;
import com.hbasesoft.xiu.xing.entity.PinJiEntity;
import com.hbasesoft.xiu.xing.service.PinJiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class PinJiServiceImpl implements PinJiService {

    @Resource
    private PinJiDao pinJiDao;

    @Override
    public PinJiEntity getPinJiById(String pinJiId) {
        return pinJiDao.get(PinJiEntity.class, pinJiId);
    }
}
