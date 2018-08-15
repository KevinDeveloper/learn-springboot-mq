package com.kevin.springmq.rabbitmqprovider.service.impl;

import com.kevin.springmq.rabbitmqprovider.service.QueueMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ClassName: QueueMessageServiceImpl
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 15:55
 */
@Slf4j
@Component
public class QueueMessageServiceImpl implements QueueMessageService {

    /**
     * 消息队列模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送消息
     *
     * @param message    消息内容
     * @param exchange   交换配置
     * @param routingKey 队列配置
     * @throws Exception
     */
    @Override
    public void send(Object message, String exchange, String routingKey) throws Exception {
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationId);

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData.getId());
        if (ack) {
            log.info("消息发送成功");
        } else {
            log.info("消息发送失败:" + cause);
        }

    }
}
