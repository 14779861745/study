package com.uchung.departmentappraise.service.exception;

/**
 * 信息为空异常类
 */
public class InfoEmptyException extends ServiceException{
    private static final long serialVersionUID = 1L;

    public InfoEmptyException() {
        super();
    }

    public InfoEmptyException(String message) {
        super(message);
    }

    public InfoEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfoEmptyException(Throwable cause) {
        super(cause);
    }

    protected InfoEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
