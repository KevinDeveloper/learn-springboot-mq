项目说明：
本项目是一个springboot集成rabbitmq的一个简单使用示例，演示不同类型的消息的从生产到消费过程。

项目结构：

rabbitmq-common：
一个rabbitmq通用配置module
主要是exchage 、queue 的定义和绑定。
三种转发模式的演示示例，DirectExchange：路由键方式转发消息。FanoutExchange：广播方式转发消息。TopicExchange：主题匹配方式转发消息。

此外，本项目包括消息的延迟消费处理。

rabbitmq-provider：
消息生产者
使用一个简单业务演示生产业务消息通过RabbitTemplate 发送到rabbitmq 队列。

rabbitmq-consumer
消息消费者
演示监听不同队列的消息，然后进行消费。

备注说明:
问题1： 

消费者使用 @RabbitListener(queues = "testmq.msg.direct.queue.rpc")方式监听队列，则会遇见以下问题：
生产者启动之后 ，在没有产生任何消息之前，此时rabbitmq中并没有生产者中定义生成的exchange 和queue。
此时启动消费者，将提示找不到队列，启动失败。

修改方案：

消费者使用 @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "testmq.msg.direct.queue.rpc", durable = "true"), exchange = @Exchange(value = "testmq.msg.direct.exchange"), key = "testmq.msg.direct.rpc")}) 方式监听，
该监听方式，如果rabbitmq中不存在相应的queue和exchange，将会自动创建。不指定Exchange 类型将会默认创建direct类型的exchange。
同时如果已经存在相应的bing类型的exchange和queue，如果exchange类型有出入，消费者启动则会报错。
                  
问题2：

在@Configuration 配置中，配置binding关系 ，有如下两种方式：
方式一：
    @Bean
    public Binding bindingTopicQueue1() {
        Binding binding = BindingBuilder.bind(createTopicQueue1()).to(topicExchange()).with(TopicQueueEnum.TOPIC_QUEUE_QUEUE_1.getRoutingKey());
        log.info("绑定 TopicQueue1 到topic 交换成功");
        return binding;
    }
和方式二：
    @Bean
    public Binding bindingTopicQueue2(TopicExchange topicExchange, Queue createTopicQueue2) {
        Binding binding = BindingBuilder.bind(createTopicQueue2).to(topicExchange).with(TopicQueueEnum.TOPIC_QUEUE_QUEUE_2.getRoutingKey());
        log.info("绑定 TopicQueue2 到topic 交换成功");
        return binding;
    }
    
修改意见：

推荐使用后者方式二。
原因：
1、方式1 会除了bean自动生成的对象之外，调用函数还会额外生成一个bean对象。
2、方式2 会自动类型配置，通过前面@Bean注解生成的对象，自动注入， 默认是按照类型配置
3、可以通过 @Qualifier("directExchange") 按名称装配， 不写也可以默认按类型装配
