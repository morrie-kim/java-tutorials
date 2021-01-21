package com.morrie.tutorials.jsks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by morrie kim on 2021/01/22.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class JavaSpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringKafkaApplication.class, args);
    }

}