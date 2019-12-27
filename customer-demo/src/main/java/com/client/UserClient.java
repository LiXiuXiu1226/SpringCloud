package com.client;

import com.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//声明这是一个Feign客户端,同时通过`value`属性指定服务名称
@FeignClient(value = "user-service",fallback= UserFallback.class)
public interface UserClient {

    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id") Long i);
}
