package com.wsy.threadsafty;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    public static boolean[] flags={false,false,false,false,false,false,false,false,false,false};
    public static VolatileState[] a={null,null,null,null,null,null,null,null,null,null};

    public static void main(String[] args) {
        int n=10;
        for(int i=0;i<n;i++) {
            new Thread(new startInit(i)).start();
            new Thread(new runTest(i)).start();
        }
    }


}

class startInit implements  Runnable{
    private  int idx;
    startInit(int i){
        this.idx=i;
    }
    @Override
    public void run() {
        VolatileTest.a[idx] = new VolatileState();
        VolatileTest.flags[idx] = true;
    }
}
class runTest implements  Runnable{
    private  int idx;
    runTest(int i){
        this.idx=i;
    }
    @Override
    public void run() {
        while (!VolatileTest.flags[idx]) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        VolatileTest.a[idx].doSomeThing();
    }
}
class VolatileState{
    void doSomeThing(){
        System.out.println("do....");
    }


}