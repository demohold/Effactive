package com.wsy.rtti.proxy;

/**
 * @author DaisyYoung.
 * @date Created in 16:19 2018/7/2
 * @version:
 */
public class Student implements Person {


    @Override
    public void findHouse() {

        System.out.println("学生找房子，要求便宜离需要近");
    }
}
