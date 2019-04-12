package lesson13;

import lesson13.annotation.AnnotetionExample;
import lesson13.annotation.Exclude;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class ReflectionExample {
    ///Рефлексия в Java

    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {

        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        System.out.println(someClass.getClass());

        Class cls = someClass.getClass();
        System.out.println("сам класс " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("родитель " + cls.getName());

        Class<SomeClass> someClassClass = SomeClass.class;

        ///доступ к полям класса
        Field[] fields = someClassClass.getFields();
        System.out.println(" " + Arrays.toString(fields));

        Field[] declared = someClassClass.getDeclaredFields();
        System.out.println(Arrays.toString(declared));


        Method[] methods = someClassClass.getMethods();
        System.out.println(Arrays.toString(methods));

        Method[] declaredMetod = someClassClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMetod));

        ////доступ к конструкторам

        Constructor<?>[] declaredConstructor = someClassClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        someClass = new SomeClass();

        ////доступ к приватному конкретному полю
        Field field = someClassClass.getDeclaredField("vertion");//возвращакет конкретное указанное поле
        System.out.println("field.getType() = " + field.getType());//тип поля

        field.setAccessible(true);
        System.out.println("get someClass " + field.get(someClass));
        field.set(someClass, 1);
        System.out.println("someClass " + someClass);

        ////доступ к приватному метод
        Method method = someClassClass.getDeclaredMethod("getinfo");
        method.setAccessible(true);

        String data = (String) method.invoke(someClass);///передаем объект у которого вызываем метод
        System.out.println("data = " + data);

        ////---------------------------------------------------
        ///конструкторы
        Constructor<SomeClass> someClassConstructor = someClassClass.getDeclaredConstructor(String.class, int.class);
        SomeClass someClass1 = someClassConstructor.newInstance("uoi", 5);
        System.out.println("someClass1 = " + someClass1);

////
        boolean isPrivate = Modifier.isFinal(field.getModifiers());//получаем модификатор доступа
        boolean isFinal = Modifier.isFinal(field.getModifiers());// и проверяем модификаторы

        ////статический toString(obj)
        ///вывести информацию по полям...

      //  toString(someClass1);
        System.out.println("-----------TOSTRING-------------");
        SomeClass someClass2 = someClassConstructor.newInstance("ttt", 5);
        toString(someClass2);
        // написать статический toString(obj),
        // который возвращает информацию о переданном объекте




    }
///---------------------------Домашка---------------------------------------------------
   public static void toString(SomeClass someClass) throws NoSuchFieldException, IllegalAccessException {

       Class<SomeClass> someCls = SomeClass.class;
       ///доступ к полям класса
       Field[] declared = someCls.getDeclaredFields();
       StringBuilder sb = new StringBuilder();
       for (Field f:declared )
       {
           Field field = someCls.getDeclaredField(f.getName());
           Annotation annotation = f.getAnnotation(Exclude.class);
           if(annotation instanceof Exclude)
           {
               Exclude mAnnotation = (Exclude) annotation;
               System.out.println("vertion annotetion= " + mAnnotation.version());
           }
           
           
           sb.append(f.getName());
               sb.append(" = ");
               f.setAccessible(true);
               sb.append(f.get(someClass));
               sb.append(' ');


       }
       System.out.println("SomeClass " + sb);
       ///----найдем по анатации
///----------обращение к анатации-------------------
//       Field field = someCls.getDeclaredField("name");
//       Annotation annotation = field.getAnnotation(Exclude.class);
//       Exclude mAnnotation = (Exclude) annotation;
//       System.out.println("vertion="+(mAnnotation.version()));
///---------------------------------------------

   }

///----------------------------------------------------------------------------------
}

class PaternClass{
    public String parentField;
    private void paternVoid()
    {
        System.out.println(" patern Void");
    }
}

///------------------------------------------------------------------------
class SomeClass extends PaternClass
{
    @Exclude(version = 4)
private String name;

    public int vertion;

    public SomeClass(String name, int vertion) {


        this.name = name;
        this.vertion = vertion;
    }

    public SomeClass() {
    }

    public SomeClass(String name) {

        this.name = name;
    }

    private String getName() {
        return name;
    }

    private String getinfo()
    {
        return "private Void";
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", vertion=" + vertion +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVertion() {
        return vertion;
    }

    public void setVertion(int vertion) {
        this.vertion = vertion;
    }
}
///----------------------------------------------------------------------------------

