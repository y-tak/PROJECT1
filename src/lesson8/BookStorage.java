package lesson8;
//расширить класс BOOK и ко всем его методам

interface  SomeInterfase<T>
{
    public T getData();
}



public class BookStorage<T extends Book> implements SomeInterfase<T>
{
private T book;

public String getBookTitle()
{
    return book.getTitle();
}

    @Override
    public T getData() {
        return null;
    }
}
