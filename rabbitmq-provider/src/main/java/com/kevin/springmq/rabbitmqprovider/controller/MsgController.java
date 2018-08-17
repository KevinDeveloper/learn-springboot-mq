package com.kevin.springmq.rabbitmqprovider.controller;

import com.kevin.springmq.rabbitmqprovider.domin.MsgBean;
import com.kevin.springmq.rabbitmqprovider.service.MsgService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: controller
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 16:17
 */
@Slf4j
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @ApiOperation(value = "发送 direct模式 消息", notes = "")
    @RequestMapping(value = "/msg-direct", method = RequestMethod.POST)
    public void addDirectMsg(MsgBean msgBean) throws Exception {
        log.info("进入到msg-direct接口");
        msgService.sendDirectMsg(msgBean);
        log.info("进入到msg-direct接口 - 结束");

    }

    @ApiOperation(value = "发送 topic模式 消息", notes = "")
    @RequestMapping(value = "/msg-topic", method = RequestMethod.POST)
    public void addTopicMsg(MsgBean msgBean) throws Exception {
        log.info("进入到msg-topic接口");
        msgService.sendTopictMsg(msgBean);
        log.info("进入到msg-topic接口 - 结束");

    }

    @ApiOperation(value = "发送 Fanout模式 消息", notes = "")
    @RequestMapping(value = "/msg-fanout", method = RequestMethod.POST)
    public void addFanoutMsg(MsgBean msgBean) throws Exception {
        log.info("进入到msg-fanout接口");
        msgService.sendFanoutMsg(msgBean);
        log.info("进入到msg-fanout接口 - 结束");

    }


    @ApiOperation(value = "发送 延迟 消息", notes = "")
    @RequestMapping(value = "/msg-ttl", method = RequestMethod.POST)
    public void addMsgTTL(MsgBean msgBean) throws Exception {
        log.info("进入到msg-ttl接口");
        msgService.sendMsgTTL(msgBean, 10000);
        log.info("进入到msg-ttl接口 - 结束");

    }

    @ApiOperation(value = "发送 mq 消息, rpc调用 返回结果", notes = "")
    @RequestMapping(value = "/msg-rpc", method = RequestMethod.POST)
    public Integer addMsgRPC(int msgValue) throws Exception {
        log.info("进入到msg-rpc接口");
        Integer result = msgService.sendDirectMsgRPC(msgValue);
        log.info("进入到msg-rpc接口 - 结束");
        return result;

    }

}
