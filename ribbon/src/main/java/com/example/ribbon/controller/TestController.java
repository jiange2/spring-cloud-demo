package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;

@RestController
public class TestController {
    private final LoadBalancerAutoConfiguration loadBalancerAutoConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public TestController(LoadBalancerAutoConfiguration loadBalancerAutoConfiguration) {
        this.loadBalancerAutoConfiguration = loadBalancerAutoConfiguration;
    }

    @GetMapping("/hello")
    public void test() throws NoSuchFieldException, IllegalAccessException {
        System.out.println(restTemplate.getClass().getClassLoader());
        //restTemplates
        System.out.println(restTemplate.getInterceptors());
        Field field = LoadBalancerAutoConfiguration.class.getDeclaredField("restTemplates");
        field.setAccessible(true);
        System.out.println(field.get(loadBalancerAutoConfiguration));
        System.out.println();
    }

}
