package com.morrie.tutorials.jsdms.support.config;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by morrie kim on 2021/01/14.
 */
@Component
public class DispatcherServletConfig extends DispatcherServlet {
    /**
     * HttpServlet.doTrace 가 요청되면, Response Header 에 Allow 된 HttpMethod 만 표시하는 목적이다.
     * 사실 해당 Class 는 없어도 무방하지만, Infra 보안검수를 위해 작성한 코드로 쓰인다.
     */

    @Override
    protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 허용하는 메서드만 Allow Header 에 전달
        response.setHeader("Allow", String.join(", ", HttpMethod.GET.name(), HttpMethod.POST.name()));

        processRequest(request, response);
    }
}
