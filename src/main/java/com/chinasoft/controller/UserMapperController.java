package com.chinasoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasoft.pojo.User;
import com.chinasoft.service.impl.UserMapperServiceImpl;

@Controller
@RequestMapping("/user")
public class UserMapperController {

	@Autowired
	UserMapperServiceImpl service;

	@RequestMapping("/findOne")
	@ResponseBody
	public User findOne() {
		System.out.println("进入方法");
		User user = service.findOne(1);
		return user;
	}
}
