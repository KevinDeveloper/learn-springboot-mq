package com.kevin.springmq.rabbitmqcommon.config;

import com.kevin.springmq.rabbitmqcommon.enums.TopicExchangeEnum;
import com.kevin.springmq.rabbitmqcommon.enums.TopicQueueEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: TopicQueueConfiguration
 * @Description: Topic 消息队列配置
 * @Author: Kevin
 * @Date: 2018/8/15 18:02
 */
@Slf4j
@Configuration
public class TopicQueueConfiguration {
    /**
     * 配置topic消息主题交换
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        TopicExchange topicExchange = new TopicExchange(TopicExchangeEnum.TOPIC_MSG_EXCHANGE.getValue());
        log.info("topic消息主题交换实例化成功。");
        return topicExchange;
    }

    /**
     * 配置topic消息
     * 消息队列 TOPIC_QUEUE_QUEUE_1
     * 并设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue createTopicQueue1() {
        Queue queue = new Queue(TopicQueueEnum.TOPIC_QUEUE_QUEUE_1.getName());
        log.info("消息队列 TOPIC_QUEUE_QUEUE_1 创建成功");
        return queue;
    }

    /**
     * 配置用户注册
     * 消息队列 TOPIC_QUEUE_QUEUE_2
     * 并设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue createTopicQueue2() {
        Queue queue = new Queue(TopicQueueEnum.TOPIC_QUEUE_QUEUE_2.getName());
        log.info("消息队列 TOPIC_QUEUE_QUEUE_2 创建成功");
        return queue;
    }

    /**
     * 绑定TopicQueue1队列到topic msg主题交换配置
     *
     * @return
     */
    @Bean
    public Binding bindingTopicQueue1() {
        Binding binding = BindingBuilder.bind(createTopicQueue1()).to(topicExchange()).with(TopicQueueEnum.TOPIC_QUEUE_QUEUE_1.getRoutingKey());
        log.info("绑定 TopicQueue1 到topic 交换成功");
        return binding;
    }

    /**
     * 绑定TopicQueue2队列到topic msg主题交换配置
     *
     * @return
     */
    @Bean
    public Binding bindingTopicQueue2(TopicExchange topicExchange, Queue createTopicQueue2) {
        Binding binding = BindingBuilder.bind(createTopicQueue2).to(topicExchange).with(TopicQueueEnum.TOPIC_QUEUE_QUEUE_2.getRoutingKey());
        log.info("绑定 TopicQueue2 到topic 交换成功");
        return binding;
    }


}
