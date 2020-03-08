package com.morrie.tutorials.jsds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by morrie kim on 2020/03/08.
 */
@EnableAspectJAutoProxy
//@EnableFeignClients
@SpringBootApplication
public class JavaSpringDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaSpringDataApplication.class, args);
    }

}