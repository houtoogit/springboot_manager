package com.sky.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;


/**
 * @发送邮件测试
 * @Author: H
 * @Date: 2021/3/10 16:01
 * @Version: 1.0.0
 */
@SpringBootApplication
public class RedisQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisQueue.class);

    /**  RedisConnectionFactory 一个基于Jedis Redis库的JedisConnectionFactory实例。连接工厂被注入到消息监听器容器和Redis模板中。  */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        /**  通过MessageListenerAdapter包装Receiver后，添加到消息侦听器容器中，并制定监听"chat" topic */
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }

    /**   消息侦听器适配器还配置为在消息到达时调用Receiver上的receiveMessage（）方法 */
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }


    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = SpringApplication.run(RedisQueue.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        LOGGER.info("Sending message...");
        template.convertAndSend("chat", "Hello from Redis!");

        latch.await();

        System.exit(0);

    }

}
