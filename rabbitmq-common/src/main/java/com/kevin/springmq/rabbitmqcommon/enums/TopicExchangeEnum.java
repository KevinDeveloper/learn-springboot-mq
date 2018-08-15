package com.kevin.springmq.rabbitmqcommon.enums;

import lombok.Getter;


/**
 * @ClassName: TopicExchangeEnum
 * @Description: 存放了队列交换配置信息
 * @Author: Kevin
 * @Date: 2018/8/15 15:29
 */
@Getter
public enum TopicExchangeEnum {
    /**
     * topic消息交换配置枚举
     */
    TOPIC_MSG_EXCHANGE("testmq.msg.topic.exchange");
    private String value;

    TopicExchangeEnum(String value) {
        this.value = value;
    }
}
