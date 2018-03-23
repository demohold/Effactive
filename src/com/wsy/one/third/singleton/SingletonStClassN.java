package com.wsy.one.third.singleton;


//单例模式，
//延时加载，只有调用SingletonHolder.insta静态内部类，线程安全nce;才会开始加载SingletonHolder类。
public class SingletonStClassN {
    private static class SingletonHolder{
        private static final SingletonStClassN instance = new SingletonStClassN();
    }
    private boolean initflag=false;
    private  SingletonStClassN(){
        synchronized (SingletonStClassN.class){
           if(!initflag) {
               initflag=true;
           }else{
               throw new RuntimeException("违法单例约束");
           }
        }
    }
    public static final SingletonStClassN getInstance(){
        return SingletonHolder.instance;
    }
}
