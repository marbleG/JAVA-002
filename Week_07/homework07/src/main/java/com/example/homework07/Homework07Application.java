package com.example.homework07;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.homework07.mapper")
public class Homework07Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework07Application.class, args);
    }

}
