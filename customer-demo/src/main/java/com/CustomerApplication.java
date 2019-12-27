package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 启动器类
 */
/*@EnableCircuitBreaker//开启熔断器
@EnableEurekaClient// 开启Eureka客户端
@SpringBootApplication*/
@SpringCloudApplication//组合注解SpringCloudApplication，上面三个可以用一个代替
@EnableFeignClients // 开启Feign功能
public class CustomerApplication {
    @Bean
    //负载均衡
    @LoadBalanced
    //restTemplate可以发出http请求
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
