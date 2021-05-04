package com.example.homework07.service.impl;

import com.example.homework07.entity.User;
import com.example.homework07.mapper.UserMapper;
import com.example.homework07.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }

    public List<User> selectAll() {

        return userMapper.selectList(null);
    }
}
