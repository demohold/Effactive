package com.wsy.one.third.accessible;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public class B {
    public static void main(String[] args) {
        /**
         * 通过反射AccessibleObject.setAccessible可以修改对象的私有属性，
         * 要序列化的时候，我们又必须有能力去处理这些字段，这时候，
         * 我们就需要调用AccessibleObject上的setAccessible()方法来允许这种访问，
         * 而由于反射类中的Field，Method和Constructor继承自AccessibleObject，
         * 因此，通过在这些类上调用setAccessible()方法，我们可以实现对这些字段的操作。
         * 但是该修改存在安全隐患，我们可以启用java.security.manager来判断程序是否具有调用setAccessible()的权限。
         * 默认情况下，内核API和扩展目录的代码具有该权限，而类路径或通过URLClassLoader加载的应用程序不拥有此权限。
         * **/
        A a1=new A();
        Field[] fields=a1.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields,true);
        try {
            System.out.println(fields[0].toString()+"="+fields[0].get(a1));
            fields[0].setInt(a1,150);
            System.out.println(fields[0].toString()+"="+fields[0].get(a1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}