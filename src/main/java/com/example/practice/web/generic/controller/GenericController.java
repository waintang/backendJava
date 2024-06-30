package com.example.practice.web.generic.controller;

import cn.hutool.core.date.DateUtil;
import com.example.practice.web.generic.dto.Apple;
import com.example.practice.web.generic.dto.Fruit;
import com.example.practice.web.generic.dto.Generic;
import com.example.practice.web.generic.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController("GenericController.v1")
@RequestMapping("/v1/generic")
public class GenericController {

        @GetMapping("/test")
        public String test() throws InterruptedException {
            System.out.println(DateUtil.formatDateTime(new Date()));
            int loopCount = 20;
            for(int loop=1;loop<=loopCount;loop++){
                Thread.sleep(1*60*1000L);
                System.out.println("已睡眠"+loop+"分钟");
                System.out.println(DateUtil.formatDateTime(new Date()));
            }

            Fruit fruit = new Fruit();
            Apple apple = new Apple();
            Person person = new Person();
            Generic generic = new Generic();
            String result = generic.getName1(person);
            System.out.println("result:"+result);
            return result;
        }
}
