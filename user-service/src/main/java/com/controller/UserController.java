package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODo
 * @Author LiXiuXiu
 * @Date 2019/12/26 上午 11:06
 */
@EnableEurekaClient//在启动类上开启Eureka客户端功能
@RestController//controller+resposebody下面不需要在声明ResponseBody
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id") Long i){
        User user=userService.queryUserById(i);
        return user;
    }
}
