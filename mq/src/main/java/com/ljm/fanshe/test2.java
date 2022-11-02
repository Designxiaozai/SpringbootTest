package com.ljm.fanshe;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test2 {


    @Test
    public void test2() throws IllegalAccessException, InstantiationException {

        Class<User> clazz = User.class; Class<User> userClass = User.class;
        User user = userClass.newInstance();
//        filed
//        try {
//            Field name = userClass.getDeclaredField("name");
//            name.setAccessible(true);
//            name.set(user,"test");
//            System.out.println(user);
//        } catch (NoSuchFieldException e ) {
//            e.printStackTrace();
//        }
//
//       clazz.getDeclaredFields();
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field f: declaredFields ){
//            System.out.println(f);
//        }

//        construcor

//        Constructor<?>[] constructors = clazz.getConstructors();
//        for (Constructor<?> constructor : constructors) {
//            System.out.println(constructor);
//        }
//        try {
//            Constructor<User> constructor = clazz.getConstructor(String.class,int.class);
//            try {
//                User user1 = constructor.newInstance("22", 2);
//                System.out.println(user1);
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//         method

        Class<User2> user2Class = User2.class;
        User2 user2 = user2Class.newInstance();
        try {
            Method test2 = user2Class.getMethod("test2", String.class, int.class);
            System.out.println(test2);
            test2.invoke(user2,"2",2);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
