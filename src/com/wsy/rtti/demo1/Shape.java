package com.wsy.rtti.demo1;

/**
 * @ Author     ：DaisyYoung.
 * @ Date       ：Created in 15:44 2018/7/1
 * @ Description：
 * @ Modified By：
 * @Version:
 */
public abstract class Shape {
    void draw() {
        System.out.println(this + " draw");
    }
    abstract public String toString();
}
