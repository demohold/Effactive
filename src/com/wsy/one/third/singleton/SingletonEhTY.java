package com.wsy.one.third.singleton;

//单例模式，饿汉模式，线程安全
public class SingletonEhTY {
//这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，
// 这时候初始化instance显然没有达到(延时加载)lazy loading的效果。
    private static SingletonEhTY INSTANCE=new SingletonEhTY();
    private  SingletonEhTY(){}
    public static SingletonEhTY getInstance(){
        return INSTANCE;
    }
}
