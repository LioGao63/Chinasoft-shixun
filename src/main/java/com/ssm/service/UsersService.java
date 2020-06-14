package com.ssm.service;

import com.ssm.model.User;

public interface UsersService {


    int login(String user,String password);

    int reg(User user);



}
