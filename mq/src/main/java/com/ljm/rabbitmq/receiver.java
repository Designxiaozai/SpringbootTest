package com.ljm.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
@RabbitListener(queues = "fanout.queue1")
public class receiver {
    @RabbitHandler
    public void process(String Str) {
        System.out.println("接收消息mq："+Str);
    }

}
