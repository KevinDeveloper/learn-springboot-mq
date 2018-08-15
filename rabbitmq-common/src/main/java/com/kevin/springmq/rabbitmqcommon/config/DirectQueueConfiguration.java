package com.kevin.springmq.rabbitmqcommon.config;

import com.kevin.springmq.rabbitmqcommon.enums.DirectExchangeEnum;
import com.kevin.springmq.rabbitmqcommon.enums.DirectQueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: DirectQueueConfiguration
 * @Description: 消息队列配置
 * @Author: Kevin
 * @Date: 2018/8/15 15:38
 */
@Slf4j
@Configuration
public class DirectQueueConfiguration {
    /**
     * 配置路由交换对象实例
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DirectExchangeEnum.DIRECT_MSG_EXCHANGE.getValue());
    }

    /**
     * 配置direct消息队列对象实例
     * 并设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue createDirectQueue() {
        return new Queue(DirectQueueEnum.DIRECT_QUEUE_QUEUE.getName(), true);
    }

    /**
     * 将direct消息队列绑定到路由交换配置上并设置指定路由键进行转发
     *
     * @return
     */
    @Bean
    public Binding bindingDirectQueue() {
        return BindingBuilder.bind(createDirectQueue()).to(directExchange()).with(DirectQueueEnum.DIRECT_QUEUE_QUEUE.getRoutingKey());
    }

}
