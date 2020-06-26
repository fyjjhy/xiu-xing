package com.hbasesoft.xiu.xing.bean;

import com.hbasesoft.framework.common.utils.date.DateUtil;
import com.hbasesoft.xiu.xing.bean.ZhenFa;
import com.hbasesoft.xiu.xing.entity.ZhenFaEntity;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see <br>
 * @since V1.0 <br>
 */
@SpringBootTest
public class BeanTest {

    @Test
    public void beanTest() {
        ZhenFaEntity entity = new ZhenFaEntity();
        entity.setId("1");
        entity.setZhenFaCode("1");
        entity.setZhenFaName("1");
        entity.setZhenFaShuXing("1");
        entity.setZhenFaMiaoShu("1");
        entity.setXiaoShuoId("1");
        entity.setUpdateTime(DateUtil.getCurrentDate());

        ZhenFa zhenFa = new ZhenFa();
        zhenFa.setZhenFaName("2");
        zhenFa.setZhenFaShuXing("1");
        zhenFa.setZhenFaMiaoShu("2");
        zhenFa.setXiaoShuoId("1");

        BeanUtils.copyProperties(zhenFa, entity);
        System.out.println(entity);
    }

}
