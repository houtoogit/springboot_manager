package com.sky.rabbitmq.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @: 消息生产方配置类 -- 直连交换机
 * @Author: H
 * @Date: 2021/3/12 15:20
 * @Version: 1.0.0
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 定义队列 起名：TestDirectQueue
     *
     * @return
     */
    @Bean
    public Queue TestDirectQueue() {

        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        // 一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("TestDirectQueue", true);
    }

    /**
     * 定义交换机 起名：TestDirectExchange
     *
     * @return
     */
    @Bean
    public DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange", true, false);

    }

    /**
     * 将队列和交换机绑定，并设置匹配键：TestDirectRouting
     *
     * @return
     */
    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

}
