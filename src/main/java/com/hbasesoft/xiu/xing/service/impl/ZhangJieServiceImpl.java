package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.ZhangJieDao;
import com.hbasesoft.xiu.xing.service.ZhangJieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年10月17日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class ZhangJieServiceImpl implements ZhangJieService {
    
    @Resource
    private ZhangJieDao zhangJieDao;

    @Override
    public int getZhangJieCount(String xiaoShuoId) {
        return zhangJieDao.getZhangJieCount(xiaoShuoId);
    }
}
