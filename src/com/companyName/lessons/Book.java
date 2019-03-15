package com.companyName.lessons;

public class Book {
    ///свойства (атрибуты, поля)
    private int pageCount;
    private String title;
    private String avtor;
    private Izdatel izdatel;


    ///методв setter задавть свойства
    public void setPageCount(int pageCount)
    {
        if (pageCount<0) {
            System.out.println("нельзя отрицательные значения " + pageCount);
            return;
        }
        //ссылка.колСтраниц=
        this.pageCount = pageCount;
    }
    public void setAvtor(String avtor)
    {
        ///this -  ссылка на объект
        //ссылка.автор =
        this.avtor = avtor;   }

    ///---как процедура  с переменными
    public void setTitle(String title)
    {
        //ссылка.название =
        this.title = title;
    }
    ///---методы создания объекта-------------------------------
    public Book(int pageCount) {
        ///предопределенные значения
        this.pageCount=pageCount;
    }

    public Book(int pageCount, String avtor, String title) {
        ///предопределенные значения
        this.pageCount=pageCount;
        this.avtor=avtor;
        this.title=title;
    }
    ////при создании объекта (значения по умолчанию)
    public Book() {
        ///предопределенные значения
        this.title="Мцыри";
        this.avtor="Лермонтов";

        // System.out.println("создал ");
    }
    ////передаем сразу созданный обеъкт

    public Book(Izdatel izd) {
        ///предопределенные значения
        this.izdatel=izd;
        // System.out.println("создал ");
    }
///-------------------------------------------------------------

    ////---методы getter----------------
    ///определяет тип метода как функция
    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAvtor() {
        return avtor;
    }

    public Izdatel getIzdatel() {
        return izdatel;
    }

    public void setIzdatel(Izdatel izdatel) {
        this.izdatel = izdatel;
    }

    ///-------------функция &вместо--&после---&перед-----
    @Override
    public String toString() {
        return " ваша книга " +
                "стр. " + pageCount +
                "Автор " + avtor + '\'' +
                "Название " + title + '\'' +
                "Издатель "  + izdatel + '\'' +
                ' ';

    }

    /////---------------------------------
}
