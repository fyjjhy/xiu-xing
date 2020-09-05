package com.hbasesoft.xiu.xing.service;

import com.hbasesoft.xiu.xing.entity.AddressEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月29日 <br>
 * @see com.hbasesoft.xiu.xing.service <br>
 * @since V1.0 <br>
 */
public interface AddressService {

    /**
     * Description: 获取地址数量<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param
     * @return <br>
     */
    @Transactional(readOnly = true)
    int getAddressCount();

    /**
     * Description: 查询父级地址列表信息<br>
     *
     * @author 付永杰<br>
     * @taskId <br>
     * @param addrType
     * @return <br>
     */
    @Transactional(readOnly = true)
    List<AddressEntity> queryAddressListByAddrType(String addrType);

}
