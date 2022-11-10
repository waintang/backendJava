package com.example.practice.web.api.controller.v1.generic;

import com.example.practice.web.api.controller.v1.generic.dto.Apple;
import com.example.practice.web.api.controller.v1.generic.dto.Fruit;
import com.example.practice.web.api.controller.v1.generic.dto.Generic;
import com.example.practice.web.api.controller.v1.generic.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GenericController.v1")
@RequestMapping("/v1/generic")
public class GenericController {

        @GetMapping("/test")
        public String test(){
            Fruit fruit = new Fruit();
            Apple apple = new Apple();
            Person person = new Person();
            Generic generic = new Generic();
            return generic.getName1(person);
        }
}
