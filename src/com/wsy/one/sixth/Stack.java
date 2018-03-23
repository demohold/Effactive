package com.wsy.one.sixth;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
        private Object[] elements;
        private int size=0;
        private static final int DEFAULT_INITIAL_CAPACITY=16;

        public Stack(){
            elements=new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e){
            ensureCapacity();
            elements[size++]=e;
        }
        public Object pop(){
            if(size==0)
                throw new EmptyStackException();
            Object result=elements[--size];
//            elements[size]=null;
            return result;
        }
        private void ensureCapacity(){
            if(elements.length==size){
                elements= Arrays.copyOf(elements,2*size+1);
            }
        }


    public static void main(String[] args) {
        Stack a=new Stack();

        String m="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for(int i=0;i<1000000000;i++){
            a.push(i+m);
            if(i%25==0 && i!=0) {
                for(int j=0 ;j<25;j++) {
                    a.pop();
                }
            }
        }
        System.out.println(a.size);
    }
}
