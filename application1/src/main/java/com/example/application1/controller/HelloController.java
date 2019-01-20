package com.example.application1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

    @PostConstruct
    public void init(){
        System.out.println("init ##########");
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name")String name){
        return "Hello " + name;
    }
}
