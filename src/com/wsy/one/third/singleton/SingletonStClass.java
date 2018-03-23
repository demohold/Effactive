package com.wsy.one.third.singleton;

import java.lang.reflect.Proxy;

//单例模式，
//延时加载，只有调用SingletonHolder.insta静态内部类，线程安全nce;才会开始加载SingletonHolder类。
//不能规避了反射攻击
public class SingletonStClass {
    private static class SingletonHolder{
        private static final SingletonStClass instance = new SingletonStClass();
    }
    private SingletonStClass(){

    }
    public static  SingletonStClass getInstance(){
        return SingletonHolder.instance;
    }

}
