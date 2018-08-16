package com.kevin.springmq.rabbitmqprovider.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @ClassName: QueueMessageService
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 15:54
 */
public interface QueueMessageService extends RabbitTemplate.ConfirmCallback {
    /**
     * 发送消息
     *
     * @param message    消息内容
     * @param exchange   交换配置
     * @param routingKey 队列配置
     * @throws Exception
     */
    void send(Object message, String exchange, String routingKey) throws Exception;

    /**
     * 发送延迟消息
     *
     * @param messageContent 消息内容
     * @param exchange       队列交换
     * @param routerKey      队列交换绑定的路由键
     * @param delayTimes     延迟时长，单位：毫秒
     */
    void sendMessageTtl(Object messageContent, String exchange, String routerKey, final long delayTimes) throws Exception;
}
