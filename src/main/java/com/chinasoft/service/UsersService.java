package com.chinasoft.service;

import com.chinasoft.model.User;

public interface UsersService {


    int login(String user,String password);

    int reg(User user);



}
