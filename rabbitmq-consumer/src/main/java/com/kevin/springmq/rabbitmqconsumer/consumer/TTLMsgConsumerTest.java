package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TTLMsgConsumer
 * @Description: 延迟消息消费者 ,
 * 测试类，测试直接将延迟队列里的消息消费之后是否还会被发送到真正的消费队列，答案是：原本将被延迟消费的消息将被直接消费，不再被延迟消息。
 * 如果测试延迟消费，请修改监听列队
 * @Author: Kevin
 * @Date: 2018/8/16 09:56
 */
@Slf4j
@Component
@RabbitListener(queues = "testmessage.center.create")
//@RabbitListener(queues = "testmessage.center.create.ttl")
public class TTLMsgConsumerTest {

    @RabbitHandler
    public void execute(String msgBean) {
        log.info("TTLMsgConsumerTest 有消息过来，消息体={}", msgBean.toString());
        log.info("原本将被延迟消费的消息被直接消费，不再被延迟消息");

    }

}
