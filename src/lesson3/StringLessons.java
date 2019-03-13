package lesson3;

import java.util.Arrays;

public class StringLessons {

    public static void main(String[] args) {
        String stroka,stroka1;
        stroka = "строковый массив";
        stroka1 = "строковый массив";
        String stroka3=new String("строка");

        String stroka4=new String("строковый Массив");
        stroka3=stroka3.intern();//добавляем в пул строк
        ////---сравнение строк

        System.out.println(""+stroka==stroka1);//не работает
        System.out.println(""+stroka==stroka3);

        System.out.println("stroka =  с регистром" + stroka.equals(stroka4));

        //сравнение без учета регистра
        System.out.println("stroka = без учета регистра " + stroka.equalsIgnoreCase(stroka4));

        System.out.println("stroka = начитсается с.. " + stroka.startsWith("ст"));
        System.out.println("stroka = кончатеся на.." + stroka.endsWith("в"));
        
        //сортировка строк
        String[] str={stroka,stroka3,stroka4,stroka1};
        Arrays.sort(str);
        
        //// конкатенация строк (сложение строк)
        String str1="зеленый";
        String str2="лес";
        String str3=""+str1+" "+str2;
        System.out.println("str3 = " + str3);
        String str4=" шишка ";
        for (int i=0;i<3;i++)
        {
            str4+=" мишка "+i;
        }
        System.out.println("str4" + str4);

///---------
        StringBuilder stringBuilder; //быстрее но не потокобезопасен
        StringBuffer stringBuffer;//медленее потокобезопасно

        str4=" шишка ";//объект строки
        StringBuilder stringBuilder1=new StringBuilder();//объект StringBilder
        stringBuilder1.append(str4);

        for (int i=0;i<3;i++)
        {
            stringBuilder1.append(" мишка ").append("-");
        }
        System.out.println(stringBuilder1.toString());

        ////
        str4=stringBuilder1.toString();
        System.out.println("подстрока "+str4.substring(5));///начиная с 2 элемента
        System.out.println(""+str4.substring(6,14));//cо второго по 8
        System.out.println("разбивает строки: " + Arrays.toString(stroka4.split("")));//разбивает
        System.out.println("убирает пробелы с начала и с конца строки: " + str4.trim());//убирает пробелы

        str4.replaceAll("-"," "); //замещает

        System.out.println(str4);



    }
}
