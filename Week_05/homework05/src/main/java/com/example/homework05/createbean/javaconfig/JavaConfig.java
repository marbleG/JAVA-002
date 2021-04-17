package com.example.homework05.createbean.javaconfig;


import com.example.homework05.createbean.autowiring.Page;
import com.example.homework05.createbean.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean(name="common")
    public Project commonProject(){
        CommonProject commonProject = new CommonProject();
        Page page = new Page();
        page.setName("login");
        commonProject.setPage(page);
        return commonProject;
    }
}
