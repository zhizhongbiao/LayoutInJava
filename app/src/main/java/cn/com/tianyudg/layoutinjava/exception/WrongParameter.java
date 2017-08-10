package cn.com.tianyudg.layoutinjava.exception;

/**
 * Created by yang on 2017/8/10.
 */

public class WrongParameter extends RuntimeException {
    public WrongParameter() {
    }

    public WrongParameter(String message) {
        super("Wrong Parameter Exception :"+message);
    }

    public WrongParameter(String message, Throwable cause) {
        super("Wrong Parameter Exception :"+message, cause);
    }

    public WrongParameter(Throwable cause) {
        super(cause);
    }

}
