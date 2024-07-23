package fun.bigtable.kraken.bean;

import fun.bigtable.kraken.exception.Type;

import java.util.Optional;

public class Result<T> {
    private T body;
    private int code;
    private String errMsg;

    private Result(T object) {
        if (object != null) {
            this.body = object;
        }
    }

    private Result() {
    }

    private Result(Integer code, String errMsg) {
        if (code != null) {
            this.code = code;
        }
        if (errMsg != null) {
            this.errMsg = errMsg;
        }
    }

    public Integer getCode() {
        return code;
    }


    public T getBody() {
        return body;
    }


    public String getErrMsg() {
        return errMsg;
    }

    public static <T> Result<T> success() {
        return new Result<>(null);
    }

    public static <T> Result<T> success(T object) {
        return new Result<>(object);
    }

    public static <T> Result<T> fail(Type type) {
        return new Result<>(type.getErrorCode(), type.getDesc());
    }

    public static <T> Result<T> fail(Type type, String err) {
        return new Result<>(type.getErrorCode(), Optional.ofNullable(err).orElse(type.getDesc()));
    }
}
