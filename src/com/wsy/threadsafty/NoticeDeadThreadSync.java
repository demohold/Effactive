package com.wsy.threadsafty;

public class NoticeDeadThreadSync {
    public static void main(String[] args) {
        FileResource a = new FileResource();
        FileResource b = new FileResource();
        //死锁程序，a文件进行修改并将a文件追加到b中。追加方法依赖修改方法。
        //此时恰好有线程在修改b同时想将b追加到a中。造成死锁。
        for (int n = 0; n < 10; n++){
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    a.updateFile();
                    b.appendFile(a);
//                    b.updateFile();
//                    a.appendFile(b);
                }
            }).start();
        }
    }
}
