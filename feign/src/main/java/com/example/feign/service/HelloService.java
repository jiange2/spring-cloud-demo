package com.example.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("hello-service")
@Service
public interface HelloService{

    @GetMapping("/hello")
    String hello();
}

