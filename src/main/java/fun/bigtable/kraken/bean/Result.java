package fun.bigtable.kraken.bean;

import fun.bigtable.kraken.constant.ResponseState;
import fun.bigtable.kraken.exception.Type;

import java.util.List;
import java.util.Optional;

public class Result<T> {
    private T body;
    private String state;
    private String errCode;
    private String errMsg;
    private List<ApiPrivacy> privacy;

    private Result(ResponseState responseState, T object) {
        this.state = responseState.getState();
        if (object != null) {
            this.body = object;
        }
    }

    public Result() {
    }

    private Result(ResponseState responseState, String errCode, String errMsg) {
        this.state = responseState.getState();
        if (errCode != null) {
            this.errCode = errCode;
        }
        if (errMsg != null) {
            this.errMsg = errMsg;
        }
    }

    public String getErrCode() {
        return errCode;
    }


    public T getBody() {
        return body;
    }


    public String getState() {
        return state;
    }


    public String getErrMsg() {
        return errMsg;
    }


    public List<ApiPrivacy> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(List<ApiPrivacy> privacy) {
        this.privacy = privacy;
    }

    public static <T> Result<T> success() {
        return new Result<>(ResponseState.SUCCESS, null);
    }

    public static <T> Result<T> success(T object) {
        return new Result<>(ResponseState.SUCCESS, object);
    }

    public static <T> Result<T> fail(Type type) {
        return new Result<>(ResponseState.FAIL, type.getErrorCode(), type.getErrorCode());
    }

    public static <T> Result<T> fail(Type type, String err) {
        return new Result<>(ResponseState.FAIL, type.getErrorCode(), Optional.ofNullable(err).orElse(type.getDesc()));
    }
}
