package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动器类
 */

@EnableDiscoveryClient//Eureka客户端
@SpringBootApplication
//直接扫描mapper包，把接口变成一个实现的对象
@MapperScan("com.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
