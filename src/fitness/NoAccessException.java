package fitness;

public class NoAccessException extends Exception {
    public NoAccessException() {
        super();
    }

    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
