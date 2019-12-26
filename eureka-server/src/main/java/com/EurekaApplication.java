package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @Description TODo
 * @Author LiXiuXiu
 * @Date 2019/12/26 下午 03:47
 */
    /**
     * 启动器类
     */
    @EnableEurekaServer//服务器端
    @SpringBootApplication
public class EurekaApplication {
        public static void main(String[] args) {
            SpringApplication.run(com.EurekaApplication.class,args);
        }
}
