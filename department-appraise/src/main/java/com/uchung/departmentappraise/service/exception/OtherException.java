package com.uchung.departmentappraise.service.exception;

/**
 * 未知错误异常类
 */
public class OtherException extends ServiceException{
    private static final long serialVersionUID = 1L;

    public OtherException() {
        super();
    }

    public OtherException(String message) {
        super(message);
    }

    public OtherException(String message, Throwable cause) {
        super(message, cause);
    }

    public OtherException(Throwable cause) {
        super(cause);
    }

    protected OtherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
