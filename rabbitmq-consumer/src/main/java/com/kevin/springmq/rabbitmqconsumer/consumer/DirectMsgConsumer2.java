package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DirectMsgConsumer2
 * @Description: DirectMsgConsumer2 和DirectMsgConsumer 都是监听同一个queue，当有消息产生的时候，会被两个消费者随机消费，同一个消息只能被某一个消费者消费一次。
 * @Author: Kevin
 * @Date: 2018/8/15 16:09
 */
@Slf4j
@Component
public class DirectMsgConsumer2 {

    @RabbitHandler
    @RabbitListener(queues = "testmq.msg.direct.queue")
    public void execute(String msgBean) {
        log.info("DirectMsgConsumer2 有消息过来，消息体={}", msgBean.toString());

    }


}
