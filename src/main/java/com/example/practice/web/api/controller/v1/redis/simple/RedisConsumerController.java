package com.example.practice.web.api.controller.v1.redis.simple;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("redisConsumerController.v1")
@RequestMapping("/v1/redis/consumer")
public class RedisConsumerController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/messages")
    public String consume(int count){
        Map<Object,Object > map = redisTemplate.opsForHash().entries("code-hash");
        String jsonStr = JSONObject.toJSONString(map);
        return jsonStr;
    }
}
