package com.kevin.springmq.rabbitmqcommon.enums;

import lombok.Getter;

/**
 * @ClassName: TopicQueueEnum
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 17:52
 */
@Getter
public enum TopicQueueEnum {
    /**
     * topic 消息枚举
     */
    TOPIC_QUEUE_QUEUE_1("testmq.msg.topic.queue.1", "testmq.msg.topic.#"),

    TOPIC_QUEUE_QUEUE_2("testmq.msg.topic.queue.2", "testmq.msg.topic.#");

    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    TopicQueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
