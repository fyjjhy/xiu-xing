package com.hbasesoft.xiu.xing.saveOrUpdate;

import com.hbasesoft.xiu.xing.Application;
import com.hbasesoft.xiu.xing.service.CongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.saveOrUpdate <br>
 * @since V1.0 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = Application.class)
public class SaveOrUpdateTest {

    @Resource
    private CongService congService;

    @Test
    public void saveOrUpdate() {
        int congCount = congService.getCongCount();
        System.out.println("从数量:"+congCount);
    }

}
