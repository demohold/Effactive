package com.wsy.one.third.singleton;

//单例模式，双重校验锁，线程安全
public class Singleton2J {
    private volatile static Singleton2J instance;
    private Singleton2J(){}
    public static Singleton2J getInstance(){
        if(instance==null){
            synchronized (Singleton2J.class){
                if(instance==null){
                    instance=new Singleton2J();
                }
            }
        }
        return instance;
    }
}
