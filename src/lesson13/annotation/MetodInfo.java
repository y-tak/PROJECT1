package lesson13.annotation;


import java.lang.annotation.*;

//@Documented
@Target(ElementType.METHOD)
//TYPE
//METOD
//FIELD
//CONSTRUSTOR
//PARAMETR
///@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MetodInfo
{
    String date();
    String avtor();
int version() default 1;

}
