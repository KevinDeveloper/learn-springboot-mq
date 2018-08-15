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
    @ApiOperation(value = "发送 direct 消息", notes = "")
    @RequestMapping(value = "/msg-direct", method = RequestMethod.POST)
    public void addDirectMsg(MsgBean msgBean) throws Exception {
        log.info("进入到msg-direct接口");
        msgService.sendDirectMsg(msgBean);
        log.info("进入到msg-direct接口 - 结束");

    }
    @ApiOperation(value = "发送 topic 消息", notes = "")
    @RequestMapping(value = "/msg-topic", method = RequestMethod.POST)
    public void addTopicMsg(MsgBean msgBean) throws Exception {
        log.info("进入到msg-topic接口");
        msgService.sendTopictMsg(msgBean);
        log.info("进入到msg-topic接口 - 结束");

    }


}
