package com.hbasesoft.xiu.xing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.hbasesoft.framework.common.Bootstrap;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class
})
@ComponentScan(basePackages = "com.hbasesoft")
@ImportResource("classpath*:META-INF/spring/*.xml")
@Configuration
public class Application {

    public static void main(final String[] args) throws Exception {
        Bootstrap.before();
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Bootstrap.after(context);
    }
}