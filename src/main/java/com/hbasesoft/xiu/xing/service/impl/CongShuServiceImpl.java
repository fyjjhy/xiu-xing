package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.CongShuDao;
import com.hbasesoft.xiu.xing.entity.CongShuEntity;
import com.hbasesoft.xiu.xing.entity.CongShuHisEntity;
import com.hbasesoft.xiu.xing.service.CongShuService;
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
public class CongShuServiceImpl implements CongShuService {

    @Resource
    private CongShuDao congShuDao;

    @Override
    public CongShuEntity getCongShuById(String congShuId) {
        return congShuDao.get(CongShuEntity.class, congShuId);
    }

    @Override
    public void updateCongShu(CongShuEntity congShuEntity) {
        congShuDao.updateEntity(congShuEntity);
    }

    @Override
    public String saveCongShu(CongShuEntity congShuEntity) {
        return (String) congShuDao.save(congShuEntity);
    }

    @Override
    public int getCongShuCount() {
        return congShuDao.getCongShuCount();
    }

    @Override
    public void delCongShuById(String congShuId) {
        congShuDao.deleteEntityById(CongShuEntity.class, congShuId);
    }

    @Override
    public CongShuHisEntity getLCongShuHis(String congShuHisId) {
        return congShuDao.get(CongShuHisEntity.class, congShuHisId);
    }
}
