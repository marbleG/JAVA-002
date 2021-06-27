package com.example.homework12;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.Destination;
import javax.jms.Session;

@SpringBootApplication
public class Homework12Application {

    public static void main(String[] args) throws Exception {
        // 定义Destination
        Destination destination = new ActiveMQTopic("test.queue");
        // 创建连接和会话
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
        conn.start();
        //自动确认
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        final TopicProducer topicProducer = new TopicProducer();
        final TopicConsumer topicConsumer = new TopicConsumer();
        topicConsumer.consumer(destination,session);
        //	final TopicConsumer topicConsumer2 = new TopicConsumer();
        //	topicConsumer2.consumer(destination,session);
        topicProducer.producer(destination,session);
        conn.close();

    }
}
