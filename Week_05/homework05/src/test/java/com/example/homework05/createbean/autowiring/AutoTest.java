package com.example.homework05.createbean.autowiring;


import com.example.homework05.createbean.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfig.class)
public class AutoTest {
    @Autowired
    private Project bulProject;
    @Test
    public void testAutowiring(){
        System.out.println(bulProject);
    }

}