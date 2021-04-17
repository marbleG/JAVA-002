package com.example.homework05.createbean.xmlconfig;

import com.example.homework05.createbean.Project;
import com.example.homework05.createbean.autowiring.Page;

//xml项目类
public class XmlProject implements Project {
    //项目名称
    String name;
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
