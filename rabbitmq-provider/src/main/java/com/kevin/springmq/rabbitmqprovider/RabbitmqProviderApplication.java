package com.kevin.springmq.rabbitmqprovider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan(value = "com.kevin.springmq")
public class RabbitmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
        log.info("--------------消息队列-消息 生产者启动成功.-----------");
    }
}
