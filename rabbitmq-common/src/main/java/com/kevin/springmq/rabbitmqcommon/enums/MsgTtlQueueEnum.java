package com.kevin.springmq.rabbitmqcommon.enums;

import lombok.Getter;

/**
 * @ClassName: MsgTtlQueueEnum
 * @Description: 消息队列枚举配置
 * @Author: Kevin
 * @Date: 2018/8/16 09:27
 */
@Getter
public enum MsgTtlQueueEnum {
    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE("testmessage.center.direct", "testmessage.center.create", "testmessage.center.create"),
    /**
     * 消息通知ttl队列
     */
    MESSAGE_TTL_QUEUE("testmessage.center.topic.ttl", "testmessage.center.create.ttl", "testmessage.center.create.ttl");
    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    MsgTtlQueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

}
