package lesson3;

import java.util.Arrays;

public class ArrayLessons {
    public static void main(String[] args) {

        ///java.util.ваArrays
        //объявление
        int[] arr; /// более предпочтительней
        int arr2[];
        /// создание

        arr =  new int[5];
        System.out.println("цифры "+Arrays.toString(arr));

        char[] chars=new char[3];
        System.out.println("буквы "+Arrays.toString(chars));

        ////размер массива
        int arrLeght=arr.length;
        System.out.println("размерность arr"+arrLeght);

        int[] arr3={9,7,-2,3,92};
        arr3=new int[]{2,4};
        System.out.println("цифры "+Arrays.toString(arr3)+"второй эл="+arr3[1]);

        int[] arr4=new int[4];
        for (int i=0;i<arr4.length;i++)
        {

            arr4[i]+=+4;
        }
        System.out.println("цифры arr4 "+Arrays.toString(arr4));

        //копирование массива
        int[] arr5={-3,2,48,33,278};
       // int[] arr6=arr5;
        int[] arr6=arr5.clone();///вариант 1
        System.out.println("цифры arr6 "+Arrays.toString(arr6));
        int[] arr7=new int[15];
        System.arraycopy(arr5,3,arr7,6,2);
        System.out.println("цифры arr7 "+Arrays.toString(arr7));
////***** (массив откуда, нач позиция из массива откуда, массив куда, нач позиция из массива куда, кол элементов)

        int[] arr8={9,7,-2,3,92};
        int[] copyarr8=Arrays.copyOf(arr8,3);
        System.out.println("цифры arr8 "+Arrays.toString(copyarr8));

        ////перебор массива
        for (int i=0;i<arr8.length;i++)
        {
            System.out.print("["+i+"]-->"+arr8[i]+" " );
            arr8[i]+=3;
        }
        System.out.println("цифры arr8 "+Arrays.toString(arr8));

        int j=0;
        ///не позволяет изменить for_each
        for (int num:arr8)
        {
            arr5[j]=arr5[j]+num;
            j++;
            System.out.print("" + num +" ");
            num += 3;
        }
        System.out.println();
        System.out.println("цифры arr8 "+Arrays.toString(arr8));
        System.out.println("цифры arr5 "+Arrays.toString(arr5));



        //сравнение массивов
        int[] arr9=new int[5];
        int[] arr10=new int[5];
        System.out.println(arr9==arr10); ///нельзя
        System.out.println(arr9.equals(arr10));//нельзя

        System.out.println(Arrays.equals(arr9,arr10));// можно..

////наполнить
        Arrays.fill(arr9,23);
        System.out.println("цифры arr9 "+Arrays.toString(arr9));
        //поиск в массиве
        int[] arr11={5,-8,54,6,8};
        System.out.println("цифры arr11 "+Arrays.toString(arr11));
        System.out.println(" поиск:" + Arrays.binarySearch(arr11,7));///вернет номер в массивк
        //-(точка входа)-1

        ///------строка
        String[] str={"fdsf","ff","sda"};//для строковых
        System.out.println(" поиск в строке "+Arrays.asList(str).contains("ff"));
        ////сортировка массива

        Arrays.sort(arr11);
        System.out.println("сортировка arr11 "+Arrays.toString(arr11));


    }
}
