//package com.morrie.tutorials.jsds.support.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * Created by morrie kim on 2020/03/09.
// */
//@Configuration
//@EnableRedisRepositories
//public class RedisRepositoryConfigV1 {
//    @Value("${spring.redis.m-host}")
//    private String writeRedisHost;
//
//    @Value("${spring.redis.s-host}")
//    private String readRedisHost;
//
//    @Value("${spring.redis.port}")
//    private int redisPort;
//
//    @Primary
//    @Bean(name = "writeRedisConnectionFactory")
//    public RedisConnectionFactory writeRedisConnectionFactory() {
//        return new LettuceConnectionFactory(writeRedisHost, redisPort);
//    }
//
//    @Bean(name = "readRedisConnectionFactory")
//    public RedisConnectionFactory readRedisConnectionFactory() {
//        return new LettuceConnectionFactory(readRedisHost, redisPort);
//    }
//
//    @Bean(name = "writeRedisTemplate")
//    public RedisTemplate<?, ?> writeRedisTemplate() {
//        return makeRedisTemplate(writeRedisConnectionFactory());
//    }
//
//    @Bean(name = "readRedisTemplate")
//    public RedisTemplate<?, ?> readRedisTemplate() {
//        return makeRedisTemplate(readRedisConnectionFactory());
//    }
//
//    @Bean(name = "writeRedisTemplateV2")
//    public RedisTemplate<?, ?> writeRedisTemplateV2(ObjectMapper mapper) {
//        return makeRedisTemplateV2(writeRedisConnectionFactory(), mapper);
//    }
//
//    @Bean(name = "readRedisTemplateV2")
//    public RedisTemplate<?, ?> readRedisTemplateV2(ObjectMapper mapper) {
//        return makeRedisTemplateV2(readRedisConnectionFactory(), mapper);
//    }
//
//    private RedisTemplate<?, ?> makeRedisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate.setConnectionFactory(factory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//
//        return redisTemplate;
//    }
//
//    private RedisTemplate<?, ?> makeRedisTemplateV2(RedisConnectionFactory factory, ObjectMapper mapper) {
//        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//
//        redisTemplate.setConnectionFactory(factory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
//
//        return redisTemplate;
//    }
//}