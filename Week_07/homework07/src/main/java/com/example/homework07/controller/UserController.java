package com.example.homework07.controller;

import com.example.homework07.entity.User;
import com.example.homework07.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    @ResponseBody
    public String addNewUser(@RequestParam String name
            , @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setPassword(password);
        userMapper.insert(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
}
