package lesson4.Files;

public class XMlDocument implements Reader{
    @Override
    public void reader() {
        System.out.println("прочитал XML");

    }

    @Override
    public void writer() {
        System.out.println("записал XML");
    }
}
