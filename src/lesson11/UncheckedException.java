package lesson11;

///не обзятельно обрабатывать

public class UncheckedException extends RuntimeException {
    public UncheckedException() {
    }

    public UncheckedException(String message) {
        super(message);
    }

    ///throw  new UncheckedException("UncheckedException",e);
    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }
}
