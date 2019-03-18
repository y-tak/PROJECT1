package lesson4.Files;

public class JSONDocument implements Reader{
    @Override
    public void reader() {
        System.out.println(" прочитал JSON");

    }

    @Override
    public void writer() {
        System.out.println(" записал JSON");
    }
}
