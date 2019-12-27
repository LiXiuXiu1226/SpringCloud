package com.client;

import com.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Description 在Feign里面使用熔断器
 * @Author LiXiuXiu
 * @Date 2019/12/27 下午 02:45
 */
@Component
public class UserFallback implements UserClient {
    @Override
    public User queryUserById(Long i) {
        User user=new User();
        user.setName("用户查询出现异常");
        return user;
    }
}
