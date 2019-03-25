package lesson8;

public class Book {
    private  String title;
    private int pageCount;


    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }
}


class OthetBook extends Book
{
    public OthetBook(String title, int pageCount) {
        super(title, pageCount);
    }
}

class  ChildBook extends Book
{
    public ChildBook(String title, int pageCount) {
        super(title, pageCount);
    }
}