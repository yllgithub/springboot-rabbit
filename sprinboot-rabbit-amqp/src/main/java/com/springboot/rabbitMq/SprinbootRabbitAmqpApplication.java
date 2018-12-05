package com.springboot.rabbitMq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置 spring.rabbitmq  RabbitProperties 相关配置
 * CachingConnectionFactory 链接工厂
 *     private String host = "localhost";
 *     private int port = 5672;
 *     private String username = "guest";
 *     private String password = "guest";
 *     private String virtualHost; 默认是 "/"
 *     private String addresses;
 *
 *  rabbitTemplate 给容器中创建 接送和发送消息
 *  amqpAdmin  给容器中创建  rabbitmq系统管理组件
 *    amqpAdmin创建删除Quence exchage binding
 * @EnableRabbit   @RabbitListener(queues = "yll")
 *
 */
@EnableRabbit //开始基于注解的RabbitMq
@SpringBootApplication
public class SprinbootRabbitAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootRabbitAmqpApplication.class, args);
    }
}
