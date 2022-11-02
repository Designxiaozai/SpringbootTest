package com.ljm.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    public String title() default "";
    public String description() default "";
}
class test2{

    @MyAnnotation(title = "2",description = "d")
    public void test2(){
        System.out.println(12);
    }
}
class test4{
    public static void main(String[] args) {
        Class aClass = null;
        try {
            aClass = Class.forName("com.ljm.zhujie.test2");
            Method test2 = aClass.getMethod("test2");
            MyAnnotation annotation = test2.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.description());
            System.out.println(annotation.title());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}


