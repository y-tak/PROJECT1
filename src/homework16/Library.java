package homework16;

import java.util.Iterator;
import java.util.concurrent.*;

public class Library {


    public static void main(String[] args) {

        ArrayBlockingQueue<Book> onHands = new ArrayBlockingQueue<>(5, true);//
        ArrayBlockingQueue<Book> onHall = new ArrayBlockingQueue<>(5, true);
        ArrayBlockingQueue<Book> listBook = new ArrayBlockingQueue(10);


        for (int i = 0; i < 10; i++) {
            listBook.add(new Book("книга " + i + "",(i%2==0)));
        }

        ExecutorService fixedPool = Executors.newFixedThreadPool(4);


        Reader reader = new Reader("Max", onHall, onHands, listBook);
        Reader reader1 = new Reader("Vera", onHall, onHands, listBook);
        Reader reader2 = new Reader("Vova", onHall, onHands, listBook);
        Reader reader3 = new Reader("Vlad", onHall, onHands, listBook);

        fixedPool.execute(reader);
        fixedPool.execute(reader1);
        fixedPool.execute(reader2);
        fixedPool.execute(reader3);

        fixedPool.shutdown();




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

        System.out.println("Читатель "+name+" взял книгу домой: " + book.getName());
        try {
            onHand.put(book);
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }


    }


    //-------------------------------------
    public void MakeHall(Book book
    ) {
        System.out.println("Читатель "+name+" взял книгу в читальный зал: " + book.getName());
        try {

            onHall.put(book);
            Thread.sleep(100);
        } catch (InterruptedException e) {


        }

    }


    @Override
    public void run() {
        while (listBook.size()>0) {
            Book book1 = null;
            try {
                book1 = listBook.take();
                Thread.sleep(100);
               if ( book1.getHome() )
                   MakeHome(book1);
               else MakeHall(book1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("больше нет книг для читателя "+name);
    }
}
////--------------------------------------------

    class Book {
        String name;
        Boolean Home;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Book(String name, Boolean home) {
            this.name = name;
            Home = home;
        }

        public Boolean getHome() {
            return Home;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", Home=" + Home +
                    '}';
        }
    }




