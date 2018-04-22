package com.wsy.threadsafty;

public class NoticeSameObjectSync {
    public static int a=0;
    public static int j=0;
    public void addInt(String prefix){
        synchronized (this){

            a++;
            System.out.println(Thread.currentThread().getName()+">>"+prefix+">>>>>a="+a);
        }

    }
    public  void addInt2(String prefix){
            j++;
            System.out.println(Thread.currentThread().getName()+"**"+prefix+"*********j="+j);

    }
    public static  void threadSafty(){
       final NoticeSameObjectSync m=new NoticeSameObjectSync();
        for(int i=0;i<3;i++){
            new Thread(() -> {
                for(int j=0;j<10;j++) {
                    m.addInt2("y");
                    m.addInt("y");
                }

            }).start();
        }
    }
    public static  void unThreadSafty(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                NoticeSameObjectSync s=new NoticeSameObjectSync();
                for(int j=0;j<10;j++) {
                    s.addInt("n");
                    s.addInt2("n");
                }
            }
        }).start();
    }
    public static void main(String[] args) {
        threadSafty();
//        unThreadSafty();

    }


}
