package com.hbasesoft.xiu.xing.service.impl;

import com.hbasesoft.xiu.xing.dao.AddressDao;
import com.hbasesoft.xiu.xing.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月29日 <br>
 * @see com.hbasesoft.xiu.xing.service.impl <br>
 * @since V1.0 <br>
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;

    @Override
    public int getAddressCount() {
        return addressDao.getAddressCount();
    }
}
