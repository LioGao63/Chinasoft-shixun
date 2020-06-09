package com.chinasoft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.User;

public interface UserMapper {

	void addUserNoPar();

	void addUserByPar(User user);

	User selectOneByPar(int id);

	@Select("select * from user")
	List<User>  selectAll();

	void deleteUser(int id);

	void updateUser(@Param("id") int id, @Param("username") String username);
	
}
