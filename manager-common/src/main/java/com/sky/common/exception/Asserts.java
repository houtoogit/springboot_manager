package com.sky.common.exception;

import com.sky.common.util.IErrorCode;

/**
 * @Description: 断言处理类，用于抛出各种API异常
 * @Author: H
 * @Date: 2020/5/20 14:27
 * @Version: 1.0
 */
public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

}
