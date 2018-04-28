package com.wsy.threadsafty;


import java.util.concurrent.CountDownLatch;

public class DoubleCheckTest {
    private final static int count=100;

    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(count);
        long start=System.currentTimeMillis();
        for(int i=0;i<count;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                        VolatileDoubleCheck safety= VolatileDoubleCheck.getInstance();
                        System.out.println(safety);
                        System.out.println(Thread.currentThread().getName()+"-"+(System.currentTimeMillis()-start));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            latch.countDown();
        }

    }
}
