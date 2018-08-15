package com.kevin.springmq.rabbitmqcommon.enums;

import lombok.Getter;


/**
 * @ClassName: DirectExchangeEnum
 * @Description: 存放了队列交换配置信息
 * @Author: Kevin
 * @Date: 2018/8/15 15:29
 */
@Getter
public enum DirectExchangeEnum {
    /**
     * direct消息交换配置枚举
     */
    DIRECT_MSG_EXCHANGE("testmq.msg.direct.exchange");
    private String value;

    DirectExchangeEnum(String value) {
        this.value = value;
    }
}
