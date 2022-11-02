package com.ljm.sheji.factoty;

public class Student extends Person{

    @Override
    void getMethod() {
        System.out.println("学生的抽象方法");
    }

    public Student(String name){
            super(name);
        }


}
