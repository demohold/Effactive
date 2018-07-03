package com.wsy.rtti.reflectdemo;



import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author DaisyYoung.
 * @date Created in 16:37 2018/7/1
 * @version:
 */
public class ShowMethods {
    private static String usage=
            "usage:\n"+
                    "ShowMethods qualified.class.name\n"+
                    "To show all methods in class or:\n"+
                    "SHowMethods qualified.class.name word \n"+
                    "To search for methods involing 'word'";
            private static Pattern p=Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if(args.length<1){
            print(usage);
            System.exit(0);
        }
        int lines=0;
        try{
         Class<?> c=Class.forName(args[0]);
            Method[] methods=c.getMethods();
            Constructor[] ctors=c.getConstructors();
            if(args.length==1){
                for(Method method:methods){
                    print(method.toString());
                }
                for(Constructor ctor:ctors){
                    print(p.matcher(ctor.toGenericString()));
                }
                lines=methods.length+ctors.length;
            }else{
                for(Method method:methods){
                    if(method.toString().indexOf(args[1])!=-1){
                        print(method.toString());
                        lines++;
                    }

                }
                for(Constructor ctor:ctors){
                    if(ctor.toString().indexOf(args[1])!=-1) {
                        print(p.matcher(ctor.toGenericString()));
                        lines++;
                    }
                }


            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static  <T> void print(T s){
        System.out.println(s);
    }
}
