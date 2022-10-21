package com.example.practice.message.queue.redis.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class Producer {
    @Autowired
    static RedisTemplate redisTemplate = new RedisTemplate();
//    Context
    public static void main(String[] args) {
//        redisTemplate.opsForList().leftPush("queue","123");
    }
}
