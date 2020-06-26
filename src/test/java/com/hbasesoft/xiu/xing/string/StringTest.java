package com.hbasesoft.xiu.xing.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2020年06月26日 <br>
 * @see com.hbasesoft.xiu.xing.string <br>
 * @since V1.0 <br>
 */
@SpringBootTest
public class StringTest {

    @Test
    public void stringEqual() {
        System.out.println(StringUtils.equals(null, null));
        System.out.println(StringUtils.equals(null, "1"));
        System.out.println(StringUtils.equals("1", null));
        System.out.println(StringUtils.equals("1", "1"));
    }

}
