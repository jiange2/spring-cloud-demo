package com.example.zuul;

import com.example.zuul.flter.ErrorCallbackFilter;
import com.example.zuul.flter.ErrorFilter;
import com.example.zuul.flter.UserAccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {

    @Bean
    @Profile("peer2")
    public UserAccessFilter userAccessFilter(){
        return new UserAccessFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}

