package lesson13;

import lesson13.annotation.AnnotetionExample;

import java.lang.reflect.*;
import java.util.Arrays;

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
        System.out.println("TOSTRING");
        String str="factory";
        toString(str);

    }


    public static void toString(Object obj) throws NoSuchFieldException {


        Class<?> objClass = obj.getClass();

        ///доступ к полям класса
        Field[] fields = objClass.getFields();
        //    System.out.println(" " + Arrays.toString(fields));

        Field[] declared = objClass.getDeclaredFields();
        //  System.out.println(Arrays.toString(declared));


        Method[] methods = objClass.getMethods();
        //   System.out.println(Arrays.toString(methods));

        Method[] declaredMetod = objClass.getDeclaredMethods();
        //    System.out.println(Arrays.toString(declaredMetod));

        boolean isPrivate = Modifier.isFinal(objClass.getModifiers());//получаем модификатор доступа
        boolean isFinal = Modifier.isFinal(objClass.getModifiers());// и проверяем модификаторы
        StringBuilder s = new StringBuilder();
        // for ( Field f:declared)
        // {

        AnnotetionExample example = new AnnotetionExample();
        Field[] fields1 = example.getClass().getDeclaredFields();
        for (Field ff:fields1)
        {
           // ff.isAnnotationPresent();///если поле включено тогда выводить

        }




         for ( Field f:declared)
        {
            s.append(objClass.getDeclaredField(f.getName()));
                }

       System.out.println(Arrays.toString(declared));



        System.out.println("SomeClass{" +
                "name='" +s.toString() + '\'' +
                ", vertion=" + //objClass.vertion +
                '}');


    }
}

class PaternClass{
    public String parentField;
    private void paternVoid()
    {
        System.out.println(" patern Void");
    }
}



class SomeClass extends PaternClass
{
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