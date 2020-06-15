package com.chinasoft.controller;


import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController{

    @Autowired
    UserServiceImpl service;


}