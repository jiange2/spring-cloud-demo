package com.example.feign.service;


import com.example.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "hello-service")
public interface HelloService{

    @GetMapping("/hello")
    String hello();
    // restTemplate.getForObj("http://hello-service/hello",String.class)
}

