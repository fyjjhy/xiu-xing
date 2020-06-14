package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.KuiLeiDao;
import com.hbasesoft.xiu.xing.service.KuiLeiService;
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
public class KuiLeiServiceImpl implements KuiLeiService {

    @Resource
    private KuiLeiDao kuiLeiDao;

    @Override
    public int getKuiLeiCount() {
        return kuiLeiDao.getKuiLeiCount();
    }
}
