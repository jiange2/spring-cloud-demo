package com.example.application1.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

    // <property key="port" value="${server.port}"/>
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, I am from " + port;
    }
}
