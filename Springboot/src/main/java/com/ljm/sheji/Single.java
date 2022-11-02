package com.ljm.sheji;

public class Single {

    private Single(){
        System.out.println("我是构造方法");
    };
    private static Single single = new Single();

    public static Single getSingle(){

        return single;
    }

}
class laySingle{

    private static laySingle single2 = null;
    private laySingle(){
        System.out.println("我是构造方法+懒汉模式");
    }
    public static laySingle getSingle2(){

        if (single2==null){
         single2=new laySingle();
        }
        return single2;
    }

}


class test1{

    public static void main(String[] args) {
        Single single = Single.getSingle();
        laySingle single2 = laySingle.getSingle2();

    }

}
