package com.sky.rabbitmq.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @: 消息生产方配置类 -- 主题交换机
 * @Author: H
 * @Date: 2021/3/12 16:09
 * @Version: 1.0.0
 */
@Configuration
public class TopicRabbitConfig {

    // 定义队列名称
    public static final String A = "A";
    public static final String B = "B";

    // 定义路由键
    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.#";

    // 定义交换机
    public static final String TopicExchange = "TopicExchange";

    @Bean
    public Queue aQueue() {
        return new Queue(A);
    }

    @Bean
    public Queue bQueue() {
        return new Queue(B);
    }

    /**
     * 定义主题交换机：TopicExchange
     *
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TopicExchange);
    }

    // 将manQueue和TopicExchange绑定,而且绑定的键值为topic.man
    // 这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    public Binding bindingExchange_a() {
        return BindingBuilder.bind(aQueue()).to(exchange()).with(MAN);
    }

    // 将womanQueue和TopicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    public Binding bindingExchange_b() {
        return BindingBuilder.bind(bQueue()).to(exchange()).with(WOMAN);
    }

}
