package com.ljm.redis;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AlertController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("api/v2/alerts")
    public void alert(@RequestBody String receiveStr, HttpServletRequest request){
        redisTemplate.opsForList().leftPush("receive",receiveStr);
//        开始存入mq
        rabbitTemplate.convertAndSend("fanout.queue1",receiveStr);
        System.out.println(receiveStr+"发送");

    }
}
