package lesson12.patterns.strategy;

public class Main {
    public static void main(String[] args) {
        LoggerContex loggerContex=new LoggerContex();
        loggerContex.setLogger(new ConsoleLogger());
        loggerContex.write("Consol info");

        loggerContex.setLogger(new FileLogger());
        loggerContex.write("File info");

    }
}
