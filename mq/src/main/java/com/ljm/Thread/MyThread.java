package com.ljm.Thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动");
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}
