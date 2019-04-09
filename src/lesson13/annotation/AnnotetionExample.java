package lesson13.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;


public class AnnotetionExample {
    String name;

    @Override
    @MetodInfo(date = "12.02.2019", avtor = "user", version = 2)
    public String toString() {
        return "AnnotationExample{" +
                "name='" + name + '\'' +
                '}';
    }

    ///-------------------------------------------------------------
    @Deprecated
    @MetodInfo(date = "12.04.2019", avtor = "user")
    public void someVoid(){
        System.out.println("Deprecated void");
    }


    ////-----------------------------------------------------------------
    public static void main(String[] args) {
        //
        AnnotetionExample example = new AnnotetionExample();
        Method[] methods = example.getClass().getDeclaredMethods();
        for (Method method: methods){
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));

            method.isAnnotationPresent(MetodInfo.class);

            MetodInfo methodInfo = method.getDeclaredAnnotation(MetodInfo.class);
            System.out.println(methodInfo);
            if (methodInfo != null){
                System.out.println(methodInfo.version());
                System.out.println(methodInfo.date());
                System.out.println(methodInfo.avtor());
            }
        }
    }

   ////---------------------------------------------------------------------

}