package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.XiaoShuoDao;
import com.hbasesoft.xiu.xing.entity.XiaoShuoEntity;
import com.hbasesoft.xiu.xing.service.XiaoShuoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年11月07日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class XiaoShuoServiceImpl implements XiaoShuoService {

    @Resource
    private XiaoShuoDao xiaoShuoDao;

    @Override
    public XiaoShuoEntity getXiaoShuo(String xiaoShuoId) {
        return xiaoShuoDao.get(XiaoShuoEntity.class, xiaoShuoId);
    }
}
