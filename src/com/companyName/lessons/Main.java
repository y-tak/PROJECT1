package com.companyName.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //тип данных  имя_объект=new создание объетк (вызов конструктора)
        Book kniga=new Book();
       // kniga.avtor="Пушкин";
      //  kniga.pageCount=300;
      //  kniga.title="Евгений Онегин";
       // System.out.println("kniga "+kniga.avtor+" "+kniga.title+"  содержит " + kniga.pageCount+" стр");

       kniga.setAvtor("Пушкин");
       kniga.setTitle("Евгений Онегин");
       kniga.setPageCount(234);

        Book kniga1=new Book();
        Book kniga2=new Book();
        kniga2.setAvtor("Тютчев");
        //присвоить значение
        kniga1.setAvtor("Толстой");
        kniga1.setTitle("Петр 1 ");
        kniga1.setPageCount(-2);
        //  kniga1.avtor="Толстой Л.Н.";
        //  kniga1.pageCount=5200;
        // kniga1.title="Война и мир";
        //System.out.println("kniga1 "+kniga1.avtor+" "+kniga1.title+"  содержит " + kniga1.pageCount+" стр");
        System.out.println("kniga1 "+kniga1.toString());   // одинаково
        System.out.println("kniga "+kniga);
        System.out.println("kniga2 "+kniga2);   // одинакове обращение

         ///срауз присвоить число страниц
        Book kniga3=new Book(345);
        kniga3.setAvtor("Барто");
        System.out.println("kniga3 "+kniga3);
        ////сразу создает объект-----
        Book kniga4=new Book(345,"Чернышевский","Что делать?");
        System.out.println("kniga4 "+kniga4);
        ///получить значанеие
        System.out.println(" в книге 4 страниц "+kniga4.getPageCount());

        Izdatel izd=new Izdatel();
        izd.setFamily("Соколов");
        izd.setName("Л.В.");
        kniga4.setIzdatel(izd);
        System.out.println(" в книге 4 страниц "+kniga4.getIzdatel().getFamily());
////---------------cразу создаем объект и преедаем в объект и в класс
        Izdatel izd1=new Izdatel("Иванов ","Петя");
        Book kniga5=new Book(izd1);
        kniga5.setAvtor("Тургенев");
        kniga5.setTitle("МУ-МУ ");
        kniga5.setPageCount(13);
        System.out.println("kniga45"+kniga5);


        Library library=new Library();
        library.addbook(kniga,0);
        library.addbook(kniga1,1);
        library.addbook(kniga2,2);
        library.addbook(kniga3,3);
        library.addbook(kniga4,4);
        library.addbook(kniga5,5);
        library.addbook(kniga2,6);
        library.addbook(kniga3,7);
        library.addbook(kniga4,8);
        library.addbook(kniga5,9);

        ///---вывести
        System.out.println("library = " + library.showbook(5));

        Scanner in=new Scanner(System.in);
        System.out.println("введите фамилию");
        String av=in.nextLine();
        Book раv=new Book();

        String avtorr;
        for (int i=0;i<10;i++)
        {
            avtorr=library.showbook(i).getAvtor();
           // System.out.println("av "+av.trim()+ " avtorr "+avtorr);

            if (avtorr.equalsIgnoreCase(av.trim())==true)
                System.out.println("книга "+i+" "+library.showbook(i));

        }

        ///-------
     //   MyList list=new Mуlist();
      ///  list.add(2);
        //// структура данных "Связанный список"
        //класс внутри класса node
        //есть значение и ссылка на следующей, 2 и ссылка.list;
        ///что сделать с послденим.. лучше сохранять послежнее значение



    }
}
