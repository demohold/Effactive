package com.wsy.reference;

import com.sun.org.apache.xpath.internal.SourceTree;

public class ReferenceTest {
    public static void main(String[] args) {
        ReferenceTest f=new ReferenceTest();
        Person person=new Person();
        person.setAge(111);
        person.setName("PERSON");
        System.out.println(person);
        Person m=f.changePerson(person);
        System.out.println("=============changes================");
        System.out.println(person);
        System.out.println(m);
    }

    Person changePerson(Person p){ 
        p=new Person();
        p.setAge(11);
        p.setName("CHANGES");
        return p;
    }
}
