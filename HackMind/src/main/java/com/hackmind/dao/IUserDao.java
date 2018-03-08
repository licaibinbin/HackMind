package com.hackmind.dao;

import com.hackmind.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface IUserDao {
    User selectUser(long id);
}

