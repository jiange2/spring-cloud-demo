package com.example.feign.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fallback")
public class HelloServiceFallback implements FallbackFactory{

    public String hello(){
        return "Hello, Fall back";
    }

    @Override
    public Object create(Throwable throwable) {
        return null;
    }
}
