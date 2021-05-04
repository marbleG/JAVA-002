package com.example.homework07.service;

import com.example.homework07.entity.User;

import java.util.List;

public interface UserService {
     int save(User user);

     List<User> selectAll();
}
