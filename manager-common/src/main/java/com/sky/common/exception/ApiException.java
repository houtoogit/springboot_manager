package com.sky.common.exception;

import com.sky.common.util.IErrorCode;

/**
 * @Description: 自定义API异常
 * @Author: H
 * @Date: 2020/5/20 14:26
 * @Version: 1.0
 */
public class ApiException extends RuntimeException {

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

}
