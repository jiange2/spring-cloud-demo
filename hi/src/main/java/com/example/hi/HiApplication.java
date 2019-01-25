package com.example.hi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.HiService;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HiApplication implements HiService {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hi")
    public String hi(){
        System.out.println("hi");
        return String.format("Hi, I am from %s", serverPort);
    }

    public static void main(String[] args) {
        SpringApplication.run(HiApplication.class, args);
    }

}

