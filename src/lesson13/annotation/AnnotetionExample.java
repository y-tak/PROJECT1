package lesson13.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AnnotetionExample {
    String name;

    @Override//переопределение родителя
    @MetodInfo(date = "04.04.2019", avtor = "ds", version = 2)
    public String toString() {
        return "AnnotetionExample{" +
                "name='" + name + '\'' +
                '}';
    }

   @Deprecated ///устаревший
   @MetodInfo(date = "08.04.2019", avtor = "ds")
    public void someVoid()
    {
    }


    public static void main(String[] args) {
        ///получить аннотацию
        AnnotetionExample example=new AnnotetionExample();
        Method[] methods=example.getClass().getDeclaredMethods();
    for (Method method:methods)
    {
        Annotation[] annotetions=method.getDeclaredAnnotations();
        System.out.println(Arrays.toString(annotetions));
      //  method.isAnnotationPresent()
    }


    }

}