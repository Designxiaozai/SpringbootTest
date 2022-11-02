package com.ljm.rabbitmq;


import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class sent {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void send(){
        String context = "简单消息发送";
        System.out.println("简单消息发送时间："+new Date());
        rabbitTemplate.convertAndSend("fanout.queue1", context);
    }

}
