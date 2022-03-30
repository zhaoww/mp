package com.banshan.wx.mp.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConnectionFactory
 *
 * @author zhaoww
 * @since 2022/3/30
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisTemplateConfig {

    /**
     * lettuce 连接工厂
     *
     * @param props redis连接属性
     * @return factory
     */
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory(RedisProperties props) {
        LettuceConnectionFactory factory = new LettuceConnectionFactory(props.getHost(), props.getPort());
        factory.setDatabase(props.getDatabase());
        return factory;
    }

    /**
     * redisTemplate
     *
     * @param props redis连接属性
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate redisTemplate(RedisProperties props) {
        return getRedisTemplate(lettuceConnectionFactory(props));
    }

    private RedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        // 开启事务 默认关闭
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 修改默认序列化器为string
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(stringRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
