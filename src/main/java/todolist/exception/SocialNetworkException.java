package todolist.exception;

public class SocialNetworkException extends RuntimeException {

    public SocialNetworkException(String message) {
        super(message);
    }

    public SocialNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    protected SocialNetworkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
