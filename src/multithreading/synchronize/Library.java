package multithreading.synchronize;



public class Library {
    public static void main(String[] args) {
        BookStorage bookStorage=new BookStorage();
        new Thread(new PutThread(bookStorage)).start();
        new Thread(new GetThread(bookStorage)).start();
    }
}

class BookStorage
{
    int bookCount=0;
//------------------------------------------------------------------------
    public synchronized void getBook() throws InterruptedException {

        System.out.println("getBook -начало выполнения");
        while (bookCount<1)
        {
            wait();///режим ожидания
            System.out.println(" getBook в ожидании"  );
        }
        bookCount--;
        System.out.println(" 1 забрали , осталось"+bookCount);
        System.out.println("getBook -окончание выполнения");
        notify();///разбудит поток случайный   notifyAll()- все
    }
////------------------------------------------------------------------
    public synchronized void putBook() throws InterruptedException {


        System.out.println("putBook -начало выполнения");
        while (bookCount>5)
        {
            wait();
            System.out.println(" putBook в ожидании"  );
        }
        bookCount++;
        System.out.println("1  положил в хранилище " + bookCount);
        System.out.println("putBook -окончание выполнения");

    }
    ///-----------------------------------------------------------------
}


class PutThread implements Runnable
{
    BookStorage bookStorage;

    public PutThread(BookStorage bookStorage)
    {
        this.bookStorage = bookStorage;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++)
        {
            try {
                bookStorage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
class GetThread implements Runnable{
    BookStorage storage;

    public GetThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            storage.getBook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}