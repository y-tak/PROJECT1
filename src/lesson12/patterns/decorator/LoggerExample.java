package lesson12.patterns.decorator;

import java.io.*;
import java.util.Date;

public class LoggerExample {
    public static void main(String[] args) {
        ILogger logger=new Logger();
        logger.write("log message");

        ILogger logger1=new DateLogger(new Logger());
        logger1.write("log message");

        ILogger logger2=new AutorLogger(new DateLogger(new Logger()));
        logger2.write("log message");

    }


}

interface ILogger{
    public  void write(String message);
}


class Logger implements ILogger{


    @Override
    public void write(String message) { //базовый класс имплементирующий метод write
        System.out.println("Console: " + message);
    }
}
///основной декоратор
class LoggerDecorator implements ILogger{ ///Базовый декоратор с конструктором

    private ILogger iLogger;

    public LoggerDecorator(ILogger iLogger) {
        this.iLogger = iLogger;
    }

    @Override
    public void write(String message) {
        iLogger.write(message);

    }
}
//////декоратор Дата
class DateLogger extends LoggerDecorator {

    public DateLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {
        String newMes=message +"  ,date:" +new Date();
        super.write(newMes);
    }
}
//декоратор Автор
class AutorLogger extends LoggerDecorator {
    public AutorLogger(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void write(String message) {

        String newMes=message+" ,autor "+System.getProperty("user.name");
        super.write(newMes);
    }
}


///---------------------------домашка-----------------------
class MyInputStream extends FilterInputStream {
    public MyInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }
}
///--------------
class MyOutputStrem extends FilterOutputStream{

    public MyOutputStrem(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }
}