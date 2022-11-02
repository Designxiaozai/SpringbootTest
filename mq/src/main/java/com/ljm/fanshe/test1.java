package com.ljm.fanshe;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class test1 {


    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void classTest() throws Exception {
        // 获取Class对象的三种方式
//        logger.info("根据类名:  \t" + User.class);
//        logger.info("根据对象:  \t" + new User().getClass());
//        logger.info("根据全限定类名:\t" + Class.forName("com.mq.fanshe.User"));
        // 常用的方法
        Class<User> userClass = User.class;
//        logger.info("获取全限定类名:\t" + userClass.getName());
//        logger.info("获取类名:\t" + userClass.getSimpleName());
//        logger.info("实例化:\t" + userClass.newInstance());
//        User user = (User) userClass.newInstance();
//        user.setAge(2);
//        System.out.println(user);
        Constructor<User> constructor = userClass.getDeclaredConstructor(int.class);
//        constructor.setAccessible(true);
//        User user1 = (User) constructor.newInstance(22);
//        System.out.println(user1);
//        Constructor<User> constructor1 = userClass.getConstructor();
//        System.out.println(constructor1);
         String name = constructor.getName();
         System.out.println(name);
        Type[] tps=constructor.getGenericParameterTypes();
        for (Type tp:tps) {
            System.out.println("参数名称tp:"+tp);
        }

    }

}
