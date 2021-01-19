package com.morrie.tutorials.jsds.common.dto;

import com.morrie.tutorials.jsds.support.code.ExceptionCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by morrie kim on 2021/01/20.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonErrorResponse {

    private Date timestamp = new Date();
    private List<FieldError> errors;
    private String code;
    private String message;
    private String path;

    private CommonErrorResponse(final String path, final ExceptionCode code, final List<FieldError> errors) {
        this.errors = errors;
        this.code = code.getCode();
        this.message = code.getMessage();
        this.path = path;
    }

    private CommonErrorResponse(final String path, final ExceptionCode code) {
        this.errors = new ArrayList<>();
        this.code = code.getCode();
        this.message = code.getMessage();
        this.path = path;
    }

    private CommonErrorResponse(final String path, final HttpStatus httpStatus) {
        this.errors = new ArrayList<>();
        this.code = httpStatus.toString();
        this.message = httpStatus.getReasonPhrase();
        this.path = path;
    }

    public static CommonErrorResponse of(final String path, final ExceptionCode code, final BindingResult bindingResult) {
        return new CommonErrorResponse(path, code, FieldError.of(bindingResult));
    }

    public static CommonErrorResponse of(final String path, final ExceptionCode code) {
        return new CommonErrorResponse(path, code);
    }

    public static CommonErrorResponse of(final String path, final ExceptionCode code, final List<FieldError> errors) {
        return new CommonErrorResponse(path, code, errors);
    }

    public static CommonErrorResponse of(final String path, MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<CommonErrorResponse.FieldError> errors = CommonErrorResponse.FieldError.of(e.getName(), value, e.getErrorCode());
        return new CommonErrorResponse(path, ExceptionCode.INVALID_PARAM, errors);
    }

    public static CommonErrorResponse of(final String path, final HttpStatus httpStatus) {
        return new CommonErrorResponse(path, httpStatus);
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<FieldError> of(final String field, final String value, final String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        public static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList())
                    ;

        }
    }
}
