package com.sky.rabbitmq.consumer.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @: 消息监听类
 * @Author: H
 * @Date: 2021/3/12 16:00
 * @Version: 1.0.0
 */
@Component
@RabbitListener(queues = "A") // 监听队列的名称：A
public class TopicReceiver {

    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("收到消费消息 -> 监听1：" + map.toString());
    }

}
