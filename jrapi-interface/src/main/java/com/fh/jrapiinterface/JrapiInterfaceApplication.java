package com.fh.jrapiinterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * YuApi 模拟接口入口类
 *
   
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class JrapiInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JrapiInterfaceApplication.class, args);
    }

}
