package com.springboot.rabbitMq.service;


import com.springboot.rabbitMq.VO.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "yll.news")
    public void reciver(Book b) {
        System.out.println("收到消息");
        System.out.println(b);
    }
    @RabbitListener(queues = "yll")
    public void reciverMessage(Message  msg) {
        System.out.println("收到消息");
        System.out.println(msg.getBody());
        System.out.println(msg.getMessageProperties());
    }
    @RabbitListener(queues = "amqp.quence")
    public void reciver01(Book  b) {
        System.out.println("收到消息");
        System.out.println(b);
    }
}
