package com.sky.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 引导类
 * @Author: H
 * @Date: 2020/5/20 10:38
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.sky.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
