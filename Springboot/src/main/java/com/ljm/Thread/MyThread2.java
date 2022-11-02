package com.ljm.Thread;

public class MyThread2 implements Runnable {
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+ "线程启动");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new MyThread2("A"));
        Thread thread2=new Thread(new MyThread2("B"));
        thread.setPriority(10);
        while (true){
           new Thread(new MyThread2("a")).start();

        }
    }
}
