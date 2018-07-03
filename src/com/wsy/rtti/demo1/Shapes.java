package com.wsy.rtti.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DaisyYoung.
 * @date Created in 16:00 2018/7/1
 * @version:
 */
public class Shapes {
    public static void main(String[] args) {
//        List<Shape> shapeList=new ArrayList<>();
//        shapeList.add(new Circle());
//        shapeList.add(new Square());
//        shapeList.add(new Triangle());
//        java.lang.reflect.
//        Shape shap=new Circle();
//        shap.draw();
        List<Shape> shapeList= Arrays.asList(new Circle(),new Circle(),new Square(),new Square(),new Triangle());
        for(Shape s:shapeList){
            //找出上面集合中的所有圆形
//            Shape
            if(s instanceof Circle){
                Class m=void.class;
                try {
                    Class n=Void.TYPE;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(s.getClass().isInstance(Circle.class)){}
            s.draw();
        }
    }

}
