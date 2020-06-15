package com.chinasoft.service.impl;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    public User selectUser(long id){

        return userMapper.selectUser(id);
    }

    public Long insertUser(User user) {
        return userMapper.insertUser(user);
    }

}
