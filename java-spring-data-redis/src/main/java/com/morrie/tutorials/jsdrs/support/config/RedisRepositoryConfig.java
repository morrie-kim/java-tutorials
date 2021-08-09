package com.morrie.tutorials.jsdrs.support.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morrie.tutorials.jsdrs.support.property.RedisProperties;
import io.lettuce.core.ReadFrom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStaticMasterReplicaConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by morrie kim on 2020/03/09.
 */
@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfig {
    final RedisProperties properties;

    public RedisRepositoryConfig(RedisProperties properties) {
        this.properties = properties;
    }

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .readFrom(ReadFrom.REPLICA_PREFERRED) // Lettuce 4.4 version, SLAVE_PREFERRED Option is DEPRECATED
                .build();

        RedisStaticMasterReplicaConfiguration staticMasterReplicaConfiguration = new RedisStaticMasterReplicaConfiguration(properties.getMaster().getHost(), properties.getMaster().getPort());
        properties.getSlaves().forEach(slave -> staticMasterReplicaConfiguration.addNode(slave.getHost(), slave.getPort()));

        return new LettuceConnectionFactory(staticMasterReplicaConfiguration, clientConfig);
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        return makeRedisTemplate(redisConnectionFactory());
    }

    private RedisTemplate<?, ?> makeRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }

    private RedisTemplate<?, ?> makeRedisTemplateV2(RedisConnectionFactory factory, ObjectMapper mapper) {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));

        return redisTemplate;
    }
}