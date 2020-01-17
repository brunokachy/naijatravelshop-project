package com.naijatravelshop.web.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by bruno on
 * Wed, 27 Mar, 2019
 */

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String REDIS_HOSTNAME;
    @Value("${spring.redis.port}")
    private int REDIS_PORT;
    @Value("${spring.redis.password}")
    private String REDIS_PASSWORD;

    @Bean
    protected JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(REDIS_HOSTNAME, REDIS_PORT);
        configuration.setPassword(RedisPassword.of(REDIS_PASSWORD));
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
        factory.getPoolConfig().setMaxIdle(30);
        factory.getPoolConfig().setMinIdle(10);
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;
    }

//    @Bean
//    public StringRedisSerializer stringRedisSerializer() {
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        return stringRedisSerializer;
//    }


//    @Bean
//    public RedisCacheManager cacheManager() {
//        RedisCacheManager redisCacheManager = new RedisCacheManager.builder()
//        redisCacheManager.setTransactionAware(true);
//
//        return redisCacheManager;
//    }
}