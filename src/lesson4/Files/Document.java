package lesson4.Files;

public class Document implements Reader {
   String type;

    public Document(String type)
    {
        this.type=type;
    }

    @Override
    public void writer() {
        System.out.println(" записал"+this.type);
    }


    @Override
    public void reader() {
        System.out.println(" прочитал "+this.type);
    }


}
