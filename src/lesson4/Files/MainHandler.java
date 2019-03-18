package lesson4.Files;

public class MainHandler {
    public static void getHandler(Reader reader)
    {
        reader.reader();
    }
    public static void setHandler(Reader reader)
    {
        reader.writer();
    }

    public static void main(String[] args) {

        Reader json=new JSONDocument();
        getHandler(json);
        setHandler(json);


        Reader xml=new XMlDocument();
        getHandler(xml);
        setHandler(xml);
    }
}
