package com.chinasoft.service;

import com.chinasoft.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperService {

	User findOne(int id);

	void addUser(User user);

	List<User> selectAll();

	void deleteUser(int id);

	void updateUser(@Param("id") int id,@Param("username") String username);
}
