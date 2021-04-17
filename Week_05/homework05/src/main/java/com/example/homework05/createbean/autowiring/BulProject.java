package com.example.homework05.createbean.autowiring;

import com.example.homework05.createbean.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//项目类
@Component("bulProject")
public class BulProject implements Project {
    //项目名称
    String name = "bul";
    //项目页面
    Page page;

    @Autowired
    public BulProject(Page page) {
        this.page = page;
    }

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
