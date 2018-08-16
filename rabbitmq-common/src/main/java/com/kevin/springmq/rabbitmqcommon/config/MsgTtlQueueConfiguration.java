package com.kevin.springmq.rabbitmqcommon.config;

import com.kevin.springmq.rabbitmqcommon.enums.MsgTtlQueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MsgTTLQueueConfiguration
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/16 09:29
 */
@Configuration
public class MsgTtlQueueConfiguration {
    /**
     * 消息中心实际消费队列交换配置
     *
     * @return
     */
    @Bean
    public DirectExchange messageDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(MsgTtlQueueEnum.MESSAGE_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心延迟消费交换配置
     *
     * @return
     */
    @Bean
    public DirectExchange messageTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(MsgTtlQueueEnum.MESSAGE_TTL_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心实际消费队列配置
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return new Queue(MsgTtlQueueEnum.MESSAGE_QUEUE.getName());
    }
    /**
     * 消息中心TTL队列
     *
     * @return
     */
    @Bean
    public Queue messageTtlQueue() {
        return QueueBuilder
                .durable(MsgTtlQueueEnum.MESSAGE_TTL_QUEUE.getName())
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", MsgTtlQueueEnum.MESSAGE_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", MsgTtlQueueEnum.MESSAGE_QUEUE.getRouteKey())
                .build();
    }


    /**
     * 消息中心实际消息交换与队列绑定
     *
     * @param messageDirect 消息中心交换配置
     * @param messageQueue  消息中心队列
     * @return
     */
    @Bean
    Binding messageBinding(DirectExchange messageDirect, Queue messageQueue) {
        return BindingBuilder
                .bind(messageQueue)
                .to(messageDirect)
                .with(MsgTtlQueueEnum.MESSAGE_QUEUE.getRouteKey());
    }
    /**
     * 消息中心TTL绑定实际消息中心实际消费交换机
     *
     * @param messageTtlQueue
     * @param messageTtlDirect
     * @return
     */
    @Bean
    public Binding messageTtlBinding(Queue messageTtlQueue, DirectExchange messageTtlDirect) {
        return BindingBuilder
                .bind(messageTtlQueue)
                .to(messageTtlDirect)
                .with(MsgTtlQueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }


}
