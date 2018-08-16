项目说明：
本项目是一个springboot集成rabbitmq的一个简单使用示例，演示不同类型的消息的从生产到消费过程。

项目结构：

rabbitmq-common：
一个rabbitmq通用配置module
主要是exchage 、queue 的定义和绑定。
direct、topic 方式转换消息
延迟消费消息

rabbitmq-provider：
消息生产者
使用一个简单业务演示生产业务消息通过RabbitTemplate 发送到rabbitmq 队列。

rabbitmq-consumer
消息消费者
演示监听不同队列的消息，然后进行消费。

