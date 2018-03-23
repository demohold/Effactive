package com.wsy.one.third.singleton;

//单例模式，饿汉模式，线程安全
public class SingletonEhTY2 {
    private static SingletonEhTY2 INSTANCE=null;
    static {
        INSTANCE=new SingletonEhTY2();
    }
    private SingletonEhTY2(){}
    public static SingletonEhTY2 getInstance(){
        return INSTANCE;
    }
}
