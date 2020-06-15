package com.chinasoft.service;

import com.chinasoft.pojo.User;


public interface UserService {

    User selectUser(long id);

    Long insertUser(User user);
}
