package com.wsy.threadsafty;

public  class ClassOrThisSync {
    Object startObject=new Object();
    static Object  staticObject=new Object();
    static {
//        synchronized (ClassOrThisSync.class){
//
//        }
//        synchronized (startObject){}
//-----------------------上面语法错误------------
//        Object m=new Object();
//        synchronized (m){}
//        synchronized (staticObject){}
    }
    public synchronized void  doSyncMethodLikeThis(){
            System.out.println(Thread.currentThread().getName() + "===doSyncMethodLikeThis....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void  a(){}
    public void doThisMethod(){
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "===doThisMethod...."+(System.currentTimeMillis())+this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //
    }
    public synchronized static void  doSyncStaicMethodLikeClass(){
        System.out.println(Thread.currentThread().getName() + "===doSyncStaicMethodLikeClass...."+(System.currentTimeMillis()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static void  doThisStaticMethod(){

    }

    public  static void  doSyncObjectClass(){
        synchronized (Object.class) {
            System.out.println(Thread.currentThread().getName() + "===doSyncObjectClass...." + (System.currentTimeMillis()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doClassMethod(){
        synchronized (ClassOrThisSync.class) {
            System.out.println(Thread.currentThread().getName() + "===doClassMethod...."+this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void noSync() {
        System.out.println(Thread.currentThread().getName() + "===noSync....");
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ClassOrThisSync c=new ClassOrThisSync();
                    c.doSyncStaicMethodLikeClass();
//                    c.doSyncMethodLikeThis();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    c.doSyncStaicMethodLikeClass();
                    ClassOrThisSync c=new ClassOrThisSync();
//                    c.doSyncStaicMethodLikeClass();
                    c.doSyncObjectClass();

//                    c.doThisMethod();

//                    c.noSync();
                }
            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    ClassOrThisSync c=new ClassOrThisSync();
//                    c.doClassMethod();
//                }
//            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    ClassOrThisSync c=new ClassOrThisSync();
//                    c.doThisMethod();
//                }
//            }).start();
        }




    }

}
