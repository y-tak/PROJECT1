package com.companyName.lessons5;

public class Library {

    Book[] books=new Book[10];

    public void addbook(Book book,int i) {

        books[i] = book;
    }

    public Book showbook(int i) {

        return books[i];
    }
}
