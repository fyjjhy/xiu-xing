package com.hbasesoft.xiu.xing.controller;

import com.hbasesoft.xiu.xing.api.AddressApi;
import com.hbasesoft.xiu.xing.entity.AddressEntity;
import com.hbasesoft.xiu.xing.service.AddressService;
import com.hbasesoft.xiu.xing.util.BeanTransferUtil;
import com.hbasesoft.xiu.xing.util.Select;
import com.hbasesoft.xiu.xing.util.TreeAble;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年05月31日 <br>
 * @see com.hbasesoft.xiu.xing.controller <br>
 * @since V1.0 <br>
 */
@RestController
public class AddressController implements AddressApi {

    @Resource
    private AddressService addressService;

    @Override
    public Object queryAddress(@RequestParam(name = "addrType", required = false) String addrType) {
        List<AddressEntity> addressEntityList = addressService.queryAddressListByAddrType(addrType);
        if (CollectionUtils.isNotEmpty(addressEntityList)) {
            if (StringUtils.isNotEmpty(addrType)) {
                List<TreeAble> selectList = addressEntityList.stream().filter(addressEntity -> {
                    if (StringUtils.isNotEmpty(addressEntity.getAddrType())) {
                        return Integer.parseInt(addressEntity.getAddrType()) < Integer.parseInt(addrType);
                    }
                    return false;
                }).map(addressEntity -> {
                    Select select = new Select();
                    select.setLabel(addressEntity.getFullName());
                    select.setParentKey(addressEntity.getPId());
                    select.setValue(addressEntity.getId());
                    select.setKey(addressEntity.getId());
                    select.setTitle(addressEntity.getFullName());
                    return select;
                }).collect(Collectors.toList());
                if (CollectionUtils.isNotEmpty(addressEntityList)) {
                    return BeanTransferUtil.transTree(selectList);
                }
            }
            else {
                return BeanTransferUtil.transTree(BeanTransferUtil.mapList(addressEntityList, addressEntity -> {
                    Select select = new Select();
                    select.setLabel(addressEntity.getFullName());
                    select.setParentKey(addressEntity.getPId());
                    select.setValue(addressEntity.getId());
                    select.setKey(addressEntity.getId());
                    select.setTitle(addressEntity.getFullName());
                    return select;
                }));
            }
        }
        return new ArrayList();
    }
}
