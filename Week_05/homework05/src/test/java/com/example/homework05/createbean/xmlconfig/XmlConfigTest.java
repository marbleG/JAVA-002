package com.example.homework05.createbean.xmlconfig;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:create-bean.xml");
        Object xmlProject = applicationContext.getBean("xmlProject");
        System.out.println(xmlProject);
    }

}