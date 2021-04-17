package com.example.homework05.starter;

import com.example.homework05_starter.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterTest implements CommandLineRunner {
    @Autowired
    private Student student;

    public static void main(String[] args) {
        SpringApplication.run(StarterTest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(student);
    }
}

