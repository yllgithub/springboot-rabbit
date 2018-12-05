package com.springboot.rabbitMq;

import com.springboot.rabbitMq.VO.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprinbootRabbitAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void contextLoads() {
        //message 需要自己构造一个,d定义消息体内容
        //  rabbitTemplate.send(exchage,rountekey,message);

        //object默认当成消息体 只需要传入要发送的对象，自动序列化给rabbitmq
        //rabbitTemplate.convertAndSend(exchage,rountekey,Object);
        HashMap<String, Object> map = new HashMap<>();
        map.put("1003","10003 first map is message");
        rabbitTemplate.convertAndSend("exchage.direct","yll",map);
    }
    //如何将数据转为json 自动发送出去
    @Test
    public void recever() {
        Object yll = rabbitTemplate.receiveAndConvert("yll");
        System.out.println(yll.getClass());
        System.out.println(yll);
    }

    @Test
    public void send_book() {
        Book book = new Book("你好 ---sas  ", "a s啥时间啊");
        rabbitTemplate.convertAndSend("exchage.fanout","yll.news",book);
    }
    @Test
    public void send_book01() {
        Book book = new Book("11是是是哈哈    ", "啊a s啥时间啊");
        rabbitTemplate.convertAndSend("amqp.exchage","amqp.hha",book);
    }
    @Test
    public void send_book_fanout() {
        Book book = new Book("西游记", "也一样");
        rabbitTemplate.convertAndSend("yll.fanout","",book);
    }

    @Test
    public void creat_exchage() {
        amqpAdmin.declareExchange(new DirectExchange("amqp.exchage"));
        System.out.println("创建完成");
    }
    @Test
    public void creat_quence() {
        amqpAdmin.declareQueue(new Queue("amqp.quence",true));
        System.out.println("创建完成");
    }
    @Test
    public void creat_binding() {
        amqpAdmin.declareBinding(new Binding("amqp.quence",Binding.DestinationType.QUEUE,"amqp.exchage","amqp.hha",null));
        System.out.println("创建完成");
    }

}
