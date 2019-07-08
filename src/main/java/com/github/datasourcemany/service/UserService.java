package com.github.datasourcemany.service;

import com.github.datasourcemany.mapper.UserMapper;
import com.github.datasourcemany.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user){
        return userMapper.insert(user);
    }
}
