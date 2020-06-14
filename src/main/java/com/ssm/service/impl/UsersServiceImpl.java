package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import com.ssm.model.UserExample;
import com.ssm.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("UsersService")
public class UsersServiceImpl implements UsersService {


    @Resource
    private UserDao userDao;

    @Override
    public int login(String user, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserEqualTo(user).andPasswordEqualTo(password).andStateEqualTo(2);
        List<User> userList = userDao.selectByExample(userExample);
        if(userList.size()>0){
            return userList.get(0).getUid();
        }else {
            return-1;
        }
    }

    @Override
    public int reg(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserEqualTo(user.getUser());
        List<User> userList = userDao.selectByExample(userExample);
        if(userList.size()>0){
            return -1;
        }else {
            user.setState(2);
            user.setImage("");
            return userDao.insertSelective(user);
        }

    }
}
