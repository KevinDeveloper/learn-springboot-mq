package com.kevin.springmq.rabbitmqprovider.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kevin.springmq.rabbitmqprovider.service.QueueMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @ClassName: QueueMessageServiceImpl
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 15:55
 */
@Slf4j
@Component
public class QueueMessageServiceImpl implements QueueMessageService {

    /**
     * 消息队列模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送消息
     *
     * @param message    消息内容
     * @param exchange   交换配置
     * @param routingKey 队列配置
     * @throws Exception
     */
    @Override
    public void send(Object message, String exchange, String routingKey) throws Exception {
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationId);

    }


    /**
     * 发送延迟消息
     *
     * @param messageContent 消息内容
     * @param exchange       队列交换
     * @param routerKey      队列交换绑定的路由键
     * @param delayTimes     延迟时长，单位：毫秒
     */
    @Override
    public void sendMessageTtl(Object messageContent, String exchange, String routerKey, final long delayTimes) {
        if (!StringUtils.isEmpty(exchange)) {
            log.info("延迟：{}毫秒写入消息队列：{}，消息内容：{}", delayTimes, routerKey, JSONObject.toJSONString(messageContent));
            //设置回调为当前类对象
            rabbitTemplate.setConfirmCallback(this);
            //构建回调id为uuid
            CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());

            // 执行发送消息到指定队列
            rabbitTemplate.convertAndSend(exchange, routerKey, messageContent, message -> {
                // 设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                log.info("getConsumerQueue={}, getConsumerTag={}", message.getMessageProperties().getConsumerQueue(), message.getMessageProperties().getConsumerTag());
                return message;
            }, correlationId);
        } else {
            log.error("未找到队列消息：{}，所属的交换机", exchange);
        }
    }

    /**
     * 测试rpc调用
     *
     * @param msgValue
     * @param exchange
     * @param routerKey
     * @return
     */
    @Override
    public Integer sendMsgRPC(int msgValue, String exchange, String routerKey) {
        //设置回调为当前类对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调id为uuid
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //发送消息到消息队列
        Integer result = (Integer) rabbitTemplate.convertSendAndReceive(exchange, routerKey, msgValue, correlationId);
        log.info("sendMsgRPC, rpc result ={}", result);
        return result;
    }


    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData.getId());
        if (ack) {
            log.info("消息发送成功");
        } else {
            log.info("消息发送失败:" + cause);
        }

    }
}
