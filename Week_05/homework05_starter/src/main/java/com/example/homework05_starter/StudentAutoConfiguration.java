package com.example.homework05_starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(StudentConfiguration.class)
@EnableConfigurationProperties(StudentProperties.class)
public class StudentAutoConfiguration {
    @Autowired
    StudentProperties properties;

    @Autowired
    StudentConfiguration configuration;

    @Bean
    public Student createInfo() {
        return new Student(configuration.name + "-" + properties.getName());
    }
}
