package com.ljm.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class AlertRunner implements CommandLineRunner {
    @Autowired
    private ALertHanlder aLertHanlder;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(String... args) throws Exception {
            ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> submit = executorService.submit(aLertHanlder);


    }
}
