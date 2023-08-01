package com.fh.jrapiinterface;

import com.fh.jrapiinterface.service.BaiduNewsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

/**
 * JrApi 模拟接口入口类
 *
 */
@SpringBootApplication
public class JrapiInterfaceApplication {


    public static void main(String[] args) {
        SpringApplication.run(JrapiInterfaceApplication.class, args);
    }

}
