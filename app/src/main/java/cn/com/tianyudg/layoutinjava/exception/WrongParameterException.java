package cn.com.tianyudg.layoutinjava.exception;

/**
 * Created by yang on 2017/8/10.
 */

public class WrongParameterException extends RuntimeException {
    public WrongParameterException() {
    }

    public WrongParameterException(String message) {
        super("Wrong Parameter Exception :"+message);
    }

    public WrongParameterException(String message, Throwable cause) {
        super("Wrong Parameter Exception :"+message, cause);
    }

    public WrongParameterException(Throwable cause) {
        super(cause);
    }

}
