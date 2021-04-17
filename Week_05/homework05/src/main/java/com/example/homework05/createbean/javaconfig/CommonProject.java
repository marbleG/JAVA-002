package com.example.homework05.createbean.javaconfig;

import com.example.homework05.createbean.autowiring.Page;
import com.example.homework05.createbean.Project;

//公共项目类
public class CommonProject implements Project {
    //项目名称
    String name = "common";
    //项目页面
    Page page;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
