package com.wsy.one.fourth;

public class Structure extends StructureFather{
    private Structure(){}
    public void whateverMethod(){}
    public Structure(String name){super(name);}
    public static void main(String[] args) {
        Structure a=new Structure("1");
    }
}
