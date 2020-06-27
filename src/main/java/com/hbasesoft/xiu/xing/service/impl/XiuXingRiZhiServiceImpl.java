package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.XiuXingRiZhiDao;
import com.hbasesoft.xiu.xing.service.XiuXingRiZhiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月27日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class XiuXingRiZhiServiceImpl implements XiuXingRiZhiService {

    @Resource
    private XiuXingRiZhiDao xiuXingRiZhiDao;

    @Override
    public int getXiuXingRiZhiCount(String cangKuId) {
        return xiuXingRiZhiDao.getXiuXingRiZhiCount(cangKuId);
    }
}
