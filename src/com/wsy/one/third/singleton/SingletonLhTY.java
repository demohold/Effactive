package com.wsy.one.third.singleton;

//单例模式，懒汉模式，线程安全
public class SingletonLhTY {

    private static SingletonLhTY INSTANCE;
    private SingletonLhTY(){}
    //增加同步锁synchronized保证线程安全，但是synchronized会影响效率，并且大部分情况下不需要同步
    public static synchronized SingletonLhTY getInstance(){
        if(INSTANCE==null){
            INSTANCE= new SingletonLhTY();
        }
        return INSTANCE;
    }
}
