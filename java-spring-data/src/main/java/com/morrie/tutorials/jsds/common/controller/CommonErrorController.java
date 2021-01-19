package com.morrie.tutorials.jsds.common.controller;

import com.morrie.tutorials.jsds.common.dto.CommonErrorResponse;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by morrie kim on 2021/01/20.
 */
@RestController
@RequestMapping("/${application.api-info.version.major:v1}/errors")
public class CommonErrorController extends AbstractErrorController {
    @Override
    public String getErrorPath() {
        return null;
    }

    public CommonErrorController(ErrorAttributes errorAttributes) { super(errorAttributes); };

    @RequestMapping
    public ResponseEntity errors(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        CommonErrorResponse errorResponse = CommonErrorResponse.of(request.getServletPath(), status);

        return ResponseEntity.status(status).body(errorResponse);

    }
}
