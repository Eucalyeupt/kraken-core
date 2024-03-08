package fun.bigtable.kraken.exception;

public abstract class IException extends RuntimeException {
    public IException(String message) {
        super(message);
    }

    public IException() {
        super();
    }

    public IException(Throwable cause) {
        super(cause);
    }

    abstract Type getErrorType();

    abstract String getErrCode();
}
