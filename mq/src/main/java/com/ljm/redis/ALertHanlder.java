package com.ljm.redis;


import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ALertHanlder implements Runnable{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public void run() {
        Thread.currentThread().setName("线程启动了");
        System.out.println("线程启动了");
        while (true){
            String receive = (String)redisTemplate.opsForList().rightPop("receive", 5, TimeUnit.SECONDS);
            if (StringUtils.isBlank(receive)) {
                System.out.println("当前为空");
                continue;
            }
            System.out.println("开始接收");
            List<AlertMessageReceiveDTO> amList = JSON.parseArray(receive, AlertMessageReceiveDTO.class);
           amList.forEach(f->{
               System.out.println(f);
           });
//            mq开始解释u

        }
    }
}
