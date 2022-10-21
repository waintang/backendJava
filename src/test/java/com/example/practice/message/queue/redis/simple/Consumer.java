package com.example.practice.message.queue.redis.simple;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class Consumer {
    static JedisConnectionFactory conn = new JedisConnectionFactory();
    static RedisTemplate redisTemplate = new RedisTemplate();
    public static void main(String[] args) {
        conn.setHostName("127.0.0.1");
        conn.setPort(6379);
        conn.setDatabase(1);
//        conn.setPassword();
        conn.setUsePool(true);
        conn.afterPropertiesSet();
        redisTemplate.setConnectionFactory(conn);
        redisTemplate.afterPropertiesSet();
        while(true){
            String message = (String)redisTemplate.opsForList().rightPop("queue",10L, TimeUnit.SECONDS);
            System.out.println("消费得到："+message);
        }
    }
}
