package lesson11;

///обрабатываемые исключения
public class CheckedException extends Exception{
    public CheckedException() {
    }

    public CheckedException(String message) {
        super(message);
    }


    ////Throwable cause - передаем объект с ошибкой
    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
