package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DirectMsgConsumer
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 16:09
 */
@Slf4j
@Component
public class DirectMsgConsumer {
    @RabbitListener(queues = "testmq.msg.direct.queue")
    @RabbitHandler
    public void execute(String msgBean) {
        log.info("DirectMsgConsumer 有消息过来，消息体={}", msgBean.toString());

    }


}
