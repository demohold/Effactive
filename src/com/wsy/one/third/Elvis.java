package com.wsy.one.third;

import java.io.Serializable;

public class Elvis {
    //直接共有域静态属性访问，这种情况反射使用AccessibleObject.setAccessible会修改掉对象实例。
    //AccessibleObject.setAccessible可以使用类的构造器，然后重新初始化实例修改。
    public static final Elvis INSTANCE=new Elvis();
    private Elvis(){

    }
    public void leaveTheBuilding(){

    }
}
class Elvis2 implements Serializable{
//共有域提供静态工厂方法，比较灵活，后面如果不想使用单例，可以直接修改getInstance的返回。
    //在序列化过程中使用序列化接口是不够的，还需要什么所有实例域是瞬时的（transient）
    //并且需要提供readResolve方法。
    //否则每次反序列化一个序列化的实例时，都会创建一个新的实例。
    //transient修正的属性则不会被反序列化存储
    //饿汉模式
    private static transient final Elvis2 INSTANCE=new Elvis2();
    private Elvis2(){

    }
    public static Elvis2 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding(){

    }
    //在反序列化过程中，jvm会调用readResolve方法直接返回该方法指定的返回对象
    private Object readResolve(){
        return INSTANCE;
    }
}


enum ElvisOfEnum{
    INSTANCE;
    private ElvisOfEnum(){}
    public void leaveTheBuilding(){}
}



class  Test{
    public static void main(String[] args) {
        ElvisOfEnum.INSTANCE.leaveTheBuilding();
    }
}