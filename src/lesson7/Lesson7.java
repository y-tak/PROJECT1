package lesson7;

import lesson4.Files.Document;

public class Lesson7 {
    public static void main(String[] args) {
        int a=5;
        ///оболочки имебщие схожий тип но и методы
        Integer intvar=5;
        Byte bytey;
        Float floatt;
       Double doublet;
        Character character;
        Short shourtV;
        Boolean gfdhj;

        ///методы

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        ///-------------
        ///методы преобрзубщие строку в число
       System.out.println(" = " +Byte.parseByte("7"));//byte
      System.out.println(Byte.valueOf("8")); //Byte
        System.out.println("Integer.parseInt() = " + Integer.parseInt("4"));//int
        System.out.println("Integer.parseInt() = " + Integer.valueOf("4"));//INteger

///методы сравнени
// -127..128
        ///объект и примитив
        Integer int1=3;
        Integer int2=3;
        if (int1==int2) System.out.println("int1 ==int2");

        Integer int3=300;
        Integer int4=400;
        if (int3==int4) System.out.println("int3 ==int4");
        else System.out.println("int2 <>int3");

     Integer ygt=int3+int4;

        System.out.println("срачнить = " + Integer.compare(int1,int2));//0-истина
        System.out.println("срачнить = " + Integer.compare(int1,int3));///-1- ложь
        System.out.println("max= " + Integer.max(int1,int4));///max/min

        System.out.println("хэшкод = " + Integer.hashCode(int3));
        System.out.println("сумма = " + Integer.sum(int3,int4));

        System.out.println(Integer.parseInt("7876") );



        int1.doubleValue();//вернет примитив double
        int1.longValue();


    }
}
