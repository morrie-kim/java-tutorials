package com.morrie.tutorials.jsdms.support.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by morrie kim on 2021/07/16.
 */
@Data
@ConfigurationProperties("spring.redis")
@Configuration
public class RedisProperties {
    private String host;
    private int port;
    private RedisProperties master;
    private List<RedisProperties> slaves;

    // TODO 구조 수정 필요

}
