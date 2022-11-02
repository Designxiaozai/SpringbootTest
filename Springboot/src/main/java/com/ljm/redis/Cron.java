package com.ljm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Cron {
    @Autowired
    private RedisTemplate redisTemplate;

//    @PostConstruct
    public void t2() throws InterruptedException {

        while (true) {
            Object test = redisTemplate.opsForList().rightPush("test", "test2");
            Thread.sleep(3200);
            System.out.println(test);
        }
    }


//    @PostConstruct
    public void test() throws InterruptedException {

        while (true){
            Object test = redisTemplate.opsForList().leftPop("test");
            Thread.sleep(3000);
            System.out.println(test);
        }
    }

}
