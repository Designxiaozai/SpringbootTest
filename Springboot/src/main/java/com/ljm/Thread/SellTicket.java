package com.ljm.Thread;

public class SellTicket implements Runnable {
    private int tickets = 100;
    int count =1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "-----------------------------" + tickets);
                    tickets--;

                } else
                    return;
            }

        }
    }
    public static void main(String[] args) {
        SellTicket st = new SellTicket();
        Thread t1 = new Thread(st,"窗口1");
        Thread t2 = new Thread(st,"窗口2");
        Thread t3 = new Thread(st,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
