package homework16;

import java.util.Iterator;
import java.util.concurrent.*;

public class Library {


    public static void main(String[] args) {

        ArrayBlockingQueue<Book> onHands = new ArrayBlockingQueue<>(2, true);//
        ArrayBlockingQueue<Book> onHall = new ArrayBlockingQueue<>(2, true);
        ArrayBlockingQueue<Book> listBook = new ArrayBlockingQueue(10);


        for (int i = 0; i < 10; i++) {
            listBook.add(new Book("книга " + i + ""));
        }

        Reader reader = new Reader("Max", onHall, onHands, listBook);
        reader.start();
        Reader reader1 = new Reader("Vera", onHall, onHands, listBook);
        reader1.start();


    }
}

//    ///-----------------------------------------------------
    class Reader extends Thread {
    String name;
    private ArrayBlockingQueue<Book> onHall;
    private ArrayBlockingQueue<Book> onHand;
    private ArrayBlockingQueue<Book> listBook;

    public Reader(String name, ArrayBlockingQueue<Book> onHall, ArrayBlockingQueue<Book> onHand, ArrayBlockingQueue<Book> listBook) {
        this.name = name;
        this.listBook = listBook;
        this.onHall = onHall;
        this.onHand = onHand;
    }

    public void MakeHome(Book book) {

        System.out.println(" Читатель"+name+" взял книгу домой " + book.getName());
        try {
            onHand.put(book);
        } catch (InterruptedException e) {

            try {
                book = onHall.take();
                System.out.println( "Читатель"+name+" вернул книгу из читального зала " + book.getName());
                listBook.put(book);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }

        }


    }


    //-------------------------------------
    public void MakeHall(Book book
    ) {
        System.out.println("  Читатель"+name+" взял книгу в читальный зал " + book.getName());
        try {

            onHall.put(book);
        } catch (InterruptedException e) {

            try {
                book = onHand.take();
                System.out.println(" Читатель"+name+" вернул книгу из дома " + book.getName());
                listBook.put(book);

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }

    }


    @Override
    public void run() {
        while (true) {
            Book book1 = null;
            try {
                book1 = listBook.take();
                MakeHall(book1);
                MakeHome(book1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
////--------------------------------------------

    class Book {
        String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Book(String name) {
            this.name = name;
        }
    }


