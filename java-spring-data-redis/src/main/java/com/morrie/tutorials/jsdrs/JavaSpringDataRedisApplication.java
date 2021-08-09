package com.morrie.tutorials.jsdrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by morrie kim on 2020/03/08.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class JavaSpringDataRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDataRedisApplication.class, args);
    }

}