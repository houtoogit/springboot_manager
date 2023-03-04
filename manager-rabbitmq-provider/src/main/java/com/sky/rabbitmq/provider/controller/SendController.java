package com.sky.rabbitmq.provider.controller;

import com.sky.common.util.CommonResult;
import com.sky.common.util.ResultCode;
import com.sky.rabbitmq.provider.config.TopicRabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: H
 * @Date: 2021/3/12 15:34
 * @Version: 1.0.0
 */
@Controller
@RequestMapping(value = "/send")
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/message/a")
    public CommonResult sendMessage_a() {

        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "猴哥");
        map.put("性别", "男");
        map.put("时间", new Date());

        // 将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);

        return CommonResult.success(ResultCode.SUCCESS, ResultCode.SUCCESS.getMessage());
    }

    @GetMapping("/message/b")
    public CommonResult sendMessage_b() {

        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "猴哥");
        map.put("性别", "男");
        map.put("时间", new Date());

        // 将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TopicExchange, TopicRabbitConfig.MAN, map);

        return CommonResult.success(ResultCode.SUCCESS, ResultCode.SUCCESS.getMessage());
    }

    @GetMapping("/message/c")
    public CommonResult sendMessage_c() {

        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "悦悦");
        map.put("性别", "女");
        map.put("时间", new Date());

        // 将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend(TopicRabbitConfig.TopicExchange, "topic.woman", map);

        return CommonResult.success(ResultCode.SUCCESS, ResultCode.SUCCESS.getMessage());
    }

}
