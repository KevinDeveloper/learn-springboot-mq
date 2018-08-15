package com.kevin.springmq.rabbitmqcommon.enums;

import lombok.Getter;

/**
 * @ClassName: DirectQueueEnum
 * @Description: 队列配置枚举
 * @Author: Kevin
 * @Date: 2018/8/15 15:37
 */
@Getter
public enum DirectQueueEnum {
    /**
     * direct消息枚举
     */
    DIRECT_QUEUE_QUEUE("testmq.msg.direct.queue","testmq.msg.direct");
    /**
     * 队列名称
     */
    private String name;
    /**
     * 队列路由键
     */
    private String routingKey;

    DirectQueueEnum(String name, String routingKey) {
        this.name = name;
        this.routingKey = routingKey;
    }
}
