package com.morrie.tutorials.jsds.support.exception;

import com.morrie.tutorials.jsds.support.code.ExceptionCode;

/**
 * Created by morrie kim on 2021/01/20.
 */
public class BadRequestException extends BaseException {

    public BadRequestException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public BadRequestException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }

    public BadRequestException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode, cause);
    }

    public BadRequestException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);
    }
}
