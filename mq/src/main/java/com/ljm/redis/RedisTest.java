package com.ljm.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class RedisTest {
@Autowired
private RedisUtil redisUtil;

    @GetMapping("test")
    public void test(){
        User user=new User();
        user.setId(2);
        user.setName("2222");
//        boolean user1 = redisUtil.set("user", user);
//        System.out.println(user1);
//        Object user2 = redisUtil.get("user");
//        System.out.println(user2);
        Map<String,Object> map= new HashMap<>();
        map.put("1",user);
        boolean userMap = redisUtil.hmset("userMap", map);
        System.out.println(userMap);
        Map<Object, Object> userMap1 = redisUtil.hmget("userMap");
        Set<Map.Entry<Object, Object>> entries = userMap1.entrySet();
        entries.forEach(k->{
            System.out.println(k.getKey());
            System.out.println(k.getValue());
        });
        userMap1.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
            User v1 = (User) v;
            System.out.println(v1);
        });



    }
}
