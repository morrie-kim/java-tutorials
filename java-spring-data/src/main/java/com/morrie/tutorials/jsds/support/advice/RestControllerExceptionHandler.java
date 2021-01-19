package com.morrie.tutorials.jsds.support.advice;

import com.morrie.tutorials.jsds.common.dto.CommonErrorResponse;
import com.morrie.tutorials.jsds.support.Exception.BadRequestException;
import com.morrie.tutorials.jsds.support.Exception.InternalServerErrorException;
import com.morrie.tutorials.jsds.support.code.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by morrie kim on 2021/01/20.
 */
@Slf4j
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity handleBadRequestException(HttpServletRequest request, BadRequestException e) {
        log.error("handleBadRequestException : {}", e.getMessage());
        final CommonErrorResponse errorResponse = CommonErrorResponse.of(request.getServletPath(), ExceptionCode.INVALID_PARAM);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException : {}", e.getMessage());
        final CommonErrorResponse errorResponse = CommonErrorResponse.of(request.getServletPath(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity handleInternalServerErrorException(HttpServletRequest request, InternalServerErrorException e) {
        log.error("handleInternalServerErrorException : {}", e.getMessage());
        final CommonErrorResponse errorResponse = CommonErrorResponse.of(request.getServletPath(), ExceptionCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, Exception e) {
        log.error("handleException : {}", e.getMessage());
        final CommonErrorResponse errorResponse = CommonErrorResponse.of(request.getServletPath(), ExceptionCode.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
