package com.banshan.wx.mp.service.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author 半山兄
 * @since 2022/03/30
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("test", "test1");
        String test = redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }
}
