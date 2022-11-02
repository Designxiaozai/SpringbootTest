package com.ljm.sheji.factoty;

public class tes{
    public static void main(String[] args) {
        Person student = (Student) ClassFactory.classFactory("学生", "学习");
        System.out.println(student.getName());
    }
}
