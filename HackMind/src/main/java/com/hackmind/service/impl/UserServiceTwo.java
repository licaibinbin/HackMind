package com.hackmind.service.impl;

import com.hackmind.entity.User;
import com.hackmind.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userServiceTwo")
public class UserServiceTwo implements IUserService {
    @Override
    public User selectUser(long id) {
        return null;
    }
}
