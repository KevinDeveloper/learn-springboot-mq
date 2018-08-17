package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: FanoutQueue1Consumer
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/16 13:56
 */
@Slf4j
@Component

public class FanoutQueue2Consumer {

    @RabbitHandler
    @RabbitListener(queues = "testmq.msg.fanout.queue_2")
    public void execute(String msgBean) {
        log.info("FanoutQueue2Consumer 有消息过来，消息体={}", msgBean.toString());

    }
}
