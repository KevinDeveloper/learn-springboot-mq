package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
//    @RabbitListener(queues = "testmq.msg.direct.queue")
//    @RabbitHandler

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "testmq.msg.direct.queue", durable = "true"),
                    exchange = @Exchange(value = "testmq.msg.direct.exchange", durable = "true"),
                    key = "testmq.msg.direct")})
    public void execute(String msgBean) {
        log.info("DirectMsgConsumer 有消息过来，消息体={}", msgBean.toString());

    }


}
