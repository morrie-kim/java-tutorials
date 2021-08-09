package com.morrie.tutorials.jsdms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by morrie kim on 2020/03/08.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class JavaSpringDataMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDataMongoApplication.class, args);
    }

}