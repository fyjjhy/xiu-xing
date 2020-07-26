package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.CangKuHisDao;
import com.hbasesoft.xiu.xing.entity.CangKuHisEntity;
import com.hbasesoft.xiu.xing.service.CangKuHisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年07月22日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class CangKuHisServiceImpl implements CangKuHisService {

    @Resource
    private CangKuHisDao cangKuHisDao;

    @Override
    public void saveOrUpdateCangKuHis(CangKuHisEntity hisEntity) {
        cangKuHisDao.save(hisEntity);
    }
}
