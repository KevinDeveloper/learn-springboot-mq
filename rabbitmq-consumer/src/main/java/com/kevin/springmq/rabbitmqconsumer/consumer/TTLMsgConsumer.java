package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TTLMsgConsumer
 * @Description: 延迟消息消费者
 * @Author: Kevin
 * @Date: 2018/8/16 09:56
 */
@Slf4j
@Component

public class TTLMsgConsumer {

    @RabbitHandler
    @RabbitListener(queues = "testmessage.center.create")
    public void execute(String msgBean) {
        log.info("TTLMsgConsumer 有消息过来，消息体={}", msgBean.toString());

    }

}
