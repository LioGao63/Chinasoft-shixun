package com.chinasoft.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserMapperService;

import java.util.List;

@Service
public class UserMapperServiceImpl implements UserMapperService {

	@Autowired
	UserMapper mapper;


	public User findOne(int id) {
		User user = mapper.selectOneByPar(id);
		return user;
	}

	public void addUser(User user){
		mapper.addUserByPar(user);
	}

	public List<User> selectAll(){
		return mapper.selectAll();
	}

	public void deleteUser(int id) {
		mapper.deleteUser(id);
	}

	public void updateUser(int id, String username){
		mapper.updateUser(id, username);
	}

}
