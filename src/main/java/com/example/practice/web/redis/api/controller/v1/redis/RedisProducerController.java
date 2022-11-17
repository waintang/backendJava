package com.example.practice.web.redis.api.controller.v1.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("redisProducerController.v1")
@RequestMapping("/v1/redis/produce")
public class RedisProducerController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/messages")
    public String produce(@RequestBody String jsonStr){
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        Map<String,Object> map = jsonObj.getInnerMap();
        redisTemplate.opsForHash().putAll("code-hash",map);
//        redisTemplate.opsForList().leftPush("TwpTest","1",map);
        return "produce redis message success.";
    }
}
