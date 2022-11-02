package com.ljm.sheji.factoty;

public class ClassFactory {

    public static Person classFactory(String Type,String name){

        switch (Type){
            case "学生":
                return new Student(name);
            default:
                return null;
        }


    }

}
