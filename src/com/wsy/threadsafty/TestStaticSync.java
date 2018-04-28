package com.wsy.threadsafty;

public class TestStaticSync {
    public static  void test(){
        synchronized (TestStaticSync.class){
            System.out.println("测试类锁");
        }
    }

    public   void testObject(){
        synchronized (this){
            System.out.println("测试对象锁");
        }
    }
}
