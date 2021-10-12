package com.example.practice.pattern.creational.prototype.deepcopy;

import com.alibaba.fastjson.JSON;
import com.example.practice.pattern.creational.prototype.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 深克隆的 四种方法（构造函数自己赋值、clone、流 序列化、Json）  之四 JSON
 *      JSON  也有 两种方式：jackson的ObjectMapper、fastjson的JSON
 */
public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {

        //jackson 的 ObjectMapper
        Account account = new Account();
        account.setId(1L);
        account.setName("TWP");
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(account);
        System.out.println(str);
        Account account1 = objectMapper.readValue(str,Account.class);
        //fastjson 的 JSON
        String jsonString = JSON.toJSONString(account);
        System.out.println(jsonString);
        Account account2 = JSON.parseObject(jsonString,Account.class);
    }
}
