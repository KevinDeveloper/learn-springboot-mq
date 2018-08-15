package com.kevin.springmq.rabbitmqconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: RabbitmqConsumer
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 15:47
 */
@Slf4j
@SpringBootApplication
public class RabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class, args);
        log.info("------------消息队列-消息 消费者启动成功.---------");
    }
}
