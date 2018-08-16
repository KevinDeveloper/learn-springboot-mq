package com.kevin.springmq.rabbitmqcommon.config;

import com.kevin.springmq.rabbitmqcommon.enums.FanoutMqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: FanoutQueueConfiguration
 * @Description: Fanout 广播方式转发消息, 这种模式只需要将队列绑定到exchange上，不需要设置路由规则。
 * @Author: Kevin
 * @Date: 2018/8/16 13:39
 */
@Slf4j
@Configuration
public class FanoutQueueConfiguration {

    @Bean
    public FanoutExchange createFanoutExchange() {
        return new FanoutExchange(FanoutMqConstant.FANOUT_EXCHANGE_1);
    }

    @Bean
    public Queue createQueueOne() {
        return new Queue(FanoutMqConstant.FANOUT_EXCHANGE_1_QUEUE_1);
    }

    @Bean
    public Queue createQueueTwo() {
        return new Queue(FanoutMqConstant.FANOUT_EXCHANGE_1_QUEUE_2);
    }

    @Bean
    public Binding bindingQueueOne() {
        return BindingBuilder.bind(createQueueOne()).to(createFanoutExchange());
    }

    @Bean
    public Binding bindingQueueTwo() {
        return BindingBuilder.bind(createQueueTwo()).to(createFanoutExchange());
    }


}
