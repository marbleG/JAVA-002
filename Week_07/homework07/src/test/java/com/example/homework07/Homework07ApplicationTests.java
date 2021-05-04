package com.example.homework07;

import com.example.homework07.entity.User;
import com.example.homework07.mapper.UserMapper;
import com.example.homework07.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework07ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


    @Test
    public void testSelect() {
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setPhone("100");
        userMapper.insert(user);
        System.out.println(("----- selectAll method test ------"));

        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
    @Test
    public void testBatchInsert() {
        User user = new User();
        for (int i = 0; i < 100; i++) {
            user.setName("test");
            user.setPassword("test");
            user.setPhone("100");
            userService.save(user);
        }
    }

    //根据方法的名称自动切换数据源
    @Test
    public void testRouting(){
        User user = new User();
        user.setName("test");
        user.setPassword("test");
        user.setPhone("100");
        //主
        userService.save(user);
        //备
        System.out.println(userService.selectAll());
        User user1 = new User();
        user1.setName("test1");
        user1.setPassword("test1");
        user1.setPhone("1001");
        //主
        userService.save(user);
    }


}
