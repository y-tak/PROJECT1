package lesson11;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CatchException
{
    public static void main(String[] args) {

        ///целочисленное деление на ноль
//        double a=7;
//        double b=0;
//
          int a=7;
        int b=0;


       // System.out.println("a/b = " + a/b);/// ArithmeticException


        //попытка полуить 10-й элемент массива приразмерности 5
        int[] arr=new int[5];
       // arr[10]=12;
       // System.out.println("arr[10] = " + Arrays.toString(arr));

///-------- null point объекта не существует
        String str=null;
       // str.equals("string");//NullPointerException

        //Integer.parseInt("dfs");//NumberFormatException


        //обработка исключений оусуществяется
 //при помощи try catch

 Object data="42";
 //Integer intData=(Integer) data;//ClassCastException

        try { Integer intData=(Integer) data;
            System.out.println(" после ошибки"  );}
        catch (ClassCastException e)
        {
            System.out.println("исключение " + e.getMessage());
        }

        ///---------------------------------

        try {
            if (System.currentTimeMillis()%2==0)
            {
                Integer intData=(Integer) data;
            }
            else arr[25]=20;
        }
        //1 вариант
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("ArrayIndexOutOfBoundsException " + e.getMessage());
//        }
//        catch (ClassCastException e){ System.out.println("ClassCastException " + e.getMessage());}

    //2 вариант
        // catch (ClassCastException | ArrayIndexOutOfBoundsException e)
        //{
      //      System.out.println("ClassCastException |ArrayIndexOutOfBoundsException " + e.getMessage());
      //  }


        //// 3 вариант RuntimeException

        catch (RuntimeException e)
        {
            System.out.println("RuntimeException " + e.getMessage());
            e.printStackTrace();

        }
        finally {
            System.out.println(" блок finally" );
        }
///-------------------------------пример обрабатываемого исключения------------
        ///---для Main обрабатываетс через try/catch
        try {
            voidWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            voiWithCheckException(6);
        }
       catch(CheckedException e)
       {
           System.out.println("CheckedException " + e.getMessage());
           try
           { throw  new UncheckedException("UncheckedException",e);
           }
           catch (UncheckedException e1)
           {
               System.out.println("UncheckedException " + e1);
           };
       }

    }

    public static void voidWithException() throws Exception {
        ///обрабатываемые исключения
//        try {
//            throw new Exception("some exception");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
       int  aa=2;
       int d=0;
       if (d==0) {
           //System.out.println(" ошибка");
           //throw new Exception("some exception");
           throw new CheckedException("Собственное ");
       }
        ///
    }


    public static void voiWithCheckException(int i) throws CheckedException
    {if (i<10) throw new CheckedException("bad int data");
    }

}
