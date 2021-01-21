package com.morrie.tutorials.jsss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by morrie kim on 2021/01/22.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class JavaSpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringSecurityApplication.class, args);
    }

}