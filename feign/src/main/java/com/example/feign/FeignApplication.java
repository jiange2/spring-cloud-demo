package com.example.feign;

import com.example.feign.service.HelloService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.HiService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class FeignApplication{

    @Autowired
    private HelloService helloService;

    @Autowired
    private HiService hiService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }

    @GetMapping("/hi")
    public String hi(){
        return hiService.hi();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}




