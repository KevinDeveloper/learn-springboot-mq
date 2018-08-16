package com.kevin.springmq.rabbitmqcommon.enums;

/**
 * @ClassName: FanoutMqConstant
 * @Description: Fanout 广播方式转发消息, 这种模式只需要将队列绑定到exchange上，不需要设置路由规则。
 * @Author: Kevin
 * @Date: 2018/8/16 13:30
 */

public interface FanoutMqConstant {

    /**
     * 交换器
     */
    String FANOUT_EXCHANGE_1 = "testmq.msg.fanout.exchange";

    /**
     * exchang1 交换器的消息通知队列
     */
    String FANOUT_EXCHANGE_1_QUEUE_1 = "testmq.msg.fanout.queue_1";
    String FANOUT_EXCHANGE_1_QUEUE_2 = "testmq.msg.fanout.queue_2";

    /**
     * Fanout 广播方式转发消息, 这种模式只需要将队列绑定到exchange上，不需要设置路由规则, 但在发送消息的时候参数不能少，定义一个统一空的队列路由键
     */
    String EMPTY_ROUTE_KEY = "fanountEmptyRouteKey";


}
