package com.service;

import com.mapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODo
 * @Author LiXiuXiu
 * @Date 2019/12/26 上午 11:07
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long i) {
        return this.userMapper.selectByPrimaryKey(i);
    }
}
