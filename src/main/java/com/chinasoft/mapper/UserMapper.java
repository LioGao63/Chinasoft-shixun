package com.chinasoft.mapper;

import com.chinasoft.pojo.User;


public interface UserMapper {

    User selectUser(long id);

    Long insertUser(User user);
}
