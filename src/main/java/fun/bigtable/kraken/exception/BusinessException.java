package fun.bigtable.kraken.exception;


public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Type type;
    private String errCode;

    public BusinessException(Type type, String errCode, String message) {
        super();
        this.type = type;
        this.errCode = errCode;
    }


    public BusinessException(Type type) {
        super();
        this.type = type;
    }

    public BusinessException(String message) {
        super(message);
        this.type = Type.DEFAULT_ERROR;
    }

    public BusinessException(Type type, String message) {
        super(message);
        this.type = type;
    }

    public BusinessException(Throwable throwable, Type type) {
        super(throwable);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "<" + getErrorType().getErrorCode() + ">";
    }

    public Type getErrorType() {
        return type;
    }

    public String getErrCode() {
        return errCode;
    }

    public static BusinessException newInstance(Type type) {
        return new BusinessException(type);
    }

}