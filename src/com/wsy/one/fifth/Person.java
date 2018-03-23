package com.wsy.one.fifth;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    //DON'T DO THIS
    //每次只需isBabyBoomer方法的时候都会创建一个Calendar对象。一个TimeZone和两个Date实例。
    public boolean isBabyBoomer(){
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        Date boomEnd=gmtCal.getTime();
        return birthDate.compareTo(boomStart)>=0 &&birthDate.compareTo(boomEnd)<0;
    }

}

class PersonOfStaticFactory{
    private final Date birthDate;
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    //只需要类加载的时候创建一次，但是如果isBabyBoomer始终不被调用，那么加载创建就是无效创建，可以采用延时加载，类懒汉模式。
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
        BOOM_END=gmtCal.getTime();
    }

    PersonOfStaticFactory(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer(){
        return birthDate.compareTo(BOOM_START)>=0 &&birthDate.compareTo(BOOM_END)<0;
    }

}


