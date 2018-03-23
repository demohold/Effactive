package com.wsy.one.third.singleton;

//单例模式，懒汉模式，线程非安全
public class SingletonLhTN {

    private static SingletonLhTN INSTANCE;
    private SingletonLhTN(){}
    public static SingletonLhTN getInstance(){
        if(INSTANCE==null){
            INSTANCE= new SingletonLhTN();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
    }
}
