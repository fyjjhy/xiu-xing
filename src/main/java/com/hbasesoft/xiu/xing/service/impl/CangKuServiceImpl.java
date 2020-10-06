package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.CangKuDao;
import com.hbasesoft.xiu.xing.entity.CangKuEntity;
import com.hbasesoft.xiu.xing.service.CangKuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年10月01日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class CangKuServiceImpl implements CangKuService {

    @Resource
    private CangKuDao cangKuDao;

    @Override
    public CangKuEntity getCangKuByCangKuId(String cangKuId) {
        return cangKuDao.get(CangKuEntity.class, cangKuId);
    }
}
