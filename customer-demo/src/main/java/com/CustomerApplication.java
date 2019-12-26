package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 启动器类
 */
@EnableEurekaClient// 开启Eureka客户端
@SpringBootApplication
public class CustomerApplication {
    @Bean
    //负载均衡
    @LoadBalanced
    //可以发出http请求
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
