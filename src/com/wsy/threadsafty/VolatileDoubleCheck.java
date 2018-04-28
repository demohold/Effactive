package com.wsy.threadsafty;


/****
 *单例模式，懒加载。双重检测模式，效率比使用synchronize关键字效率高。与静态内部类实现效率相近
 * synchronize保证有序执行，但是不能保证底层指令重排。
 *但是要注意的是需要使用volatile防止指令重排，目前测试没有测试出指令重排导致的不安全现象.
 * 指令重排序是为了优化指令，提高程序运行效率。指令重排序包括编译器重排序和运行时重排序。
 * JVM规范规定，指令重排序可以在不影响单线程程序执行结果前提下进行。例如 instance = new Singleton() 可分解为如下伪代码：
  memory = allocate();   //1：分配对象的内存空间
  ctorInstance(memory);  //2：初始化对象
  instance = memory;     //3：设置instance指向刚分配的内存地址
 但是经过重排序后如下：

 memory = allocate();   //1：分配对象的内存空间
 instance = memory;     //3：设置instance指向刚分配的内存地址
 //ka.
 //注意，此时对象还没有被初始化！
 ctorInstance(memory);  //2：初始化对象
 将第2步和第3步调换顺序，在单线程情况下不会影响程序执行的结果，但是在多线程情况下就不一样了。
 线程A执行了instance = memory（这对另一个线程B来说是可见的），此时线程B执行外层 if (instance == null)，发现instance不为空，
 随即返回，但是得到的却是未被完全初始化的实例，在使用的时候必定会有风险，这正是双重检查锁定的问题所在！
 *
 * 以上描述为http://blog.csdn.net/zhangzeyuaaa/article/details/42673245博客中的解释描述
 * */
public class VolatileDoubleCheck {
    private volatile static VolatileDoubleCheck instance;
//    public final double s;
    private VolatileDoubleCheck() {
//        s=Math.random();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
    public void doSomeThing(){
        System.out.println("doSomeThing......");
    }
    public static VolatileDoubleCheck getInstance(){
        if(instance==null){
            synchronized(VolatileDoubleCheck.class){
                if(instance==null){
                    instance=new VolatileDoubleCheck();
                }
            }
        }
        return instance;
    }
    public synchronized static VolatileDoubleCheck getInstance2(){
//        if(instance==null){
//            synchronized(VolatileDoubleCheck.class){
                if(instance==null){
                    instance=new VolatileDoubleCheck();
                }
//            }
//        }
        return instance;
    }

}
