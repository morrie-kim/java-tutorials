package com.morrie.tutorials.jsdrs.support.code;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by morrie kim on 2021/01/20.
 */
public enum ExceptionCode {

    // Common
    INVALID_PARAM("C00001", "Invalid Parameter"),
    INTERNAL_SERVER_ERROR("C00002", "Internal Server Error")
    ;

    private String code;
    private String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() { return code; }

    public String getMessage() { return message; }


}
