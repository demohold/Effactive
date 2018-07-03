package com.wsy.rtti.proxy;

/**
 * @author DaisyYoung.
 * @date Created in 18:18 2018/7/2
 * @version:
 */
public class Test {
    public static void main(String[] args) {
       Person o=(Person) new Zhongjie().getInstance(new Student());
       System.out.println(o.getClass());
      Student m= new Student();
        System.out.println(m.getClass());
//        o.findHouse();
    }
}
