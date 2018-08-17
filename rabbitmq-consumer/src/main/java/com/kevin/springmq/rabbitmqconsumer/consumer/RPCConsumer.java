package com.kevin.springmq.rabbitmqconsumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RPCConsumer
 * @Description:
 * @Author: Kevin
 * @Date: 2018/8/15 16:09
 */
@Slf4j
@Component

public class RPCConsumer {
    @RabbitHandler
    @RabbitListener(queues = "testmq.msg.direct.queue.rpc")
    public int execute(int msgValue) {
        log.info("RPCConsumer 有消息过来，消息体={}", msgValue);
        int result = fib(msgValue);
        log.info("RPCConsumer 有消息过来, 结果={}", result);
        return result;
    }

    public int fib(int n) {
        return n == 0 ? 0 : n == 1 ? 1 : (fib(n - 1) + fib(n - 2));
    }

}
