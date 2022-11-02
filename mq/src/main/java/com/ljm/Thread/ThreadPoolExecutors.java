package com.ljm.Thread;

import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.*;

public class ThreadPoolExecutors {
    private  int  t=10;
    @Test
    public void test1() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(() -> {
            System.out.println("hello world");
        });
    }

    @Test
    public void test2(){

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 20; i++) {
            myTest myTest=new myTest("kkkk"+ String.valueOf(UUID.randomUUID()));
            executorService.execute(myTest);
        }
    }
   class myTest implements Runnable{

     private String userName;
       public myTest(String userName) {
           this.userName = userName;
       }

       @Override
       public void run() {
//
           synchronized (myTest.class){
               if (t>0){
                   System.out.println(userName  +"--------------------------成功");
                   t=t-1;
                   System.out.println("票还有"+ t);
               }else {
                   System.out.println("票没了");
               }

           }

       }
   }

   @Test
    public  void test56() throws ExecutionException, InterruptedException {

       ExecutorService executorService = Executors.newFixedThreadPool(2);
       CompletableFuture completableFuture=new CompletableFuture();
       executorService.execute(new Thread(() -> System.out.println("12332")));
       completableFuture.complete("完成");
       Object o = completableFuture.get();
       System.out.println(o);

   }

}
