package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TopicQueue1Consumer
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 18:14
 */
@Slf4j
@Component
@RabbitListener(queues = "testmq.msg.topic.queue.1")
public class TopicQueue1Consumer {
    @RabbitHandler
    public void execute(String msgBean) {
        log.info("TopicQueue1Consumer 有消息过来，消息体={}", msgBean.toString());

    }
}
