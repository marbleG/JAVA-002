package com.example.homework05_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Homework05StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework05StarterApplication.class, args);
    }

    @Autowired
    Student student;

    @Bean
    public void printInfo(){
        System.out.println(student.getName());
    }

}
