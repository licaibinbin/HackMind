package com.hackmind.service.impl;

import com.hackmind.dao.IUserDao;
import com.hackmind.service.IUserService;
import com.hackmind.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;


    public  User selectUser(long id){
        return this.userDao.selectUser(id);
    }

}
