package com.example.ribbon;

import com.example.ribbon.config.TestQuilifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class RibbonApplication {

    // config
    /**
     *  <bean class="org.springframework.web.client"/>
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // controller
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(restTemplate);
        return restTemplate.getForObject("http://hello-service/hello",String.class);
    }

    // starter
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

}

