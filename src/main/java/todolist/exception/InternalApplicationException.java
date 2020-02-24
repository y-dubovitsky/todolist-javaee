package todolist.exception;

public class InternalApplicationException extends RuntimeException {
    
    public InternalApplicationException(String message) {
        super(message);
    }

    public InternalApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    protected InternalApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
