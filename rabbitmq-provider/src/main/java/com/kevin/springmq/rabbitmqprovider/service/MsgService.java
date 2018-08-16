package com.kevin.springmq.rabbitmqprovider.service;

import com.kevin.springmq.rabbitmqcommon.enums.DirectExchangeEnum;
import com.kevin.springmq.rabbitmqcommon.enums.DirectQueueEnum;
import com.kevin.springmq.rabbitmqcommon.enums.MsgTtlQueueEnum;
import com.kevin.springmq.rabbitmqcommon.enums.TopicExchangeEnum;
import com.kevin.springmq.rabbitmqcommon.enums.TopicQueueEnum;
import com.kevin.springmq.rabbitmqprovider.domin.MsgBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 16:03
 */
@Slf4j
@Service
public class MsgService {
    @Autowired
    private QueueMessageService queueMessageService;

    /**
     * 发现direct消息
     *
     * @param msgBean
     * @throws Exception
     */
    public void sendDirectMsg(MsgBean msgBean) throws Exception {
        log.info("sendDirectMsg msgBean-----start");
        log.info("msgBean={}", msgBean.toString());
        log.info("sendDirectMsg msgBean-----end");

        queueMessageService.send(msgBean.toString(), DirectExchangeEnum.DIRECT_MSG_EXCHANGE.getValue(), DirectQueueEnum.DIRECT_QUEUE_QUEUE.getRoutingKey());
    }

    /**
     * 发送topic消息
     *
     * @param msgBean
     * @throws Exception
     */
    public void sendTopictMsg(MsgBean msgBean) throws Exception {
        log.info("sendTopictMsg msgBean-----start");
        log.info("msgBean={}", msgBean.toString());
        log.info("sendTopictMsg msgBean-----end");

        queueMessageService.send(msgBean.toString(), TopicExchangeEnum.TOPIC_MSG_EXCHANGE.getValue(), TopicQueueEnum.TOPIC_QUEUE_QUEUE_1.getRoutingKey());
    }


    /**
     * 发送延迟消息
     *
     * @param msgBean
     * @throws Exception
     */
    public void sendMsgTTL(MsgBean msgBean, long delayTimes) throws Exception {
        log.info("sendMsgTTL msgBean-----start");
        String msgContent = msgBean.toString() + ", 时间" + new Date();
        log.info("msgContent={}", msgContent);

        queueMessageService.sendMessageTtl(msgContent, MsgTtlQueueEnum.MESSAGE_TTL_QUEUE.getExchange(), MsgTtlQueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(), delayTimes);
        log.info("sendMsgTTL msgBean-----end");


    }

}
