package com.example.homework05.createbean.autowiring;


import org.springframework.stereotype.Component;

//页面类
@Component
public class Page {
    //页面名称
    String name  = "bul";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                '}';
    }
}
