package com.wsy.rtti.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author DaisyYoung.
 * @date Created in 17:00 2018/7/2
 * @version:
 */
public class Zhongjie implements InvocationHandler {
    Person person;
    public Object getInstance(Person p){
        this.person=p;
        Class<?> clazz=person.getClass();
        return   Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.toString());
        //System.out.println(proxy);
        System.out.println("收到需求帮你找房子");
        method.invoke(person,args);
        System.out.println("如果合适,开始付款租房");
        return null;
    }
}
