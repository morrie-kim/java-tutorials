package com.morrie.tutorials.jsdrs.support.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrie.tutorials.jsdrs.support.interceptor.LoggerInterceptor;
import com.morrie.tutorials.jsdrs.support.xss.HtmlCharacterEscapes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by morrie kim on 2021/01/14.
 */
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${application.info.version.major}")
    private String majorVersion;

    private final String[] defaultOrigins = {
            "http://admin.shop.com",
            "https://admin.shop.com"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((new LoggerInterceptor()))
                .addPathPatterns("/**")
                .excludePathPatterns("/actuator/**", "swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/error", "/csrf");

        log.info("Web request interceptor has initialized.");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/" + majorVersion + "/users/**").allowedOrigins(defaultOrigins);

        log.info("CORS Mapping has initialized.");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(escapingConverter());
    }

    @Bean
    public HttpMessageConverter escapingConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());

        MappingJackson2HttpMessageConverter escapingConverter = new MappingJackson2HttpMessageConverter();
        escapingConverter.setObjectMapper(objectMapper);

        return escapingConverter;
    }
}
