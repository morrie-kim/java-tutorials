package com.morrie.tutorials.jsds.support.exception;

import com.morrie.tutorials.jsds.support.code.ExceptionCode;

/**
 * Created by morrie kim on 2021/01/20.
 */
public class InternalServerErrorException extends BaseException {

    public InternalServerErrorException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public InternalServerErrorException(String message, ExceptionCode exceptionCode) {
        super(message, exceptionCode);
    }

    public InternalServerErrorException(ExceptionCode exceptionCode, Throwable cause) {
        super(exceptionCode, cause);
    }

    public InternalServerErrorException(String message, ExceptionCode exceptionCode, Throwable cause) {
        super(message, exceptionCode, cause);
    }
}
