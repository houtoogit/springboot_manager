package com.sky.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: H
 * @Date: 2021/3/13 20:46
 * @Version: 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer // 开启eureka服务
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
