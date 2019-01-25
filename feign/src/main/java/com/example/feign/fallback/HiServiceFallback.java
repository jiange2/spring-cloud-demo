package com.example.feign.fallback;

import com.example.feign.service.FeignHiService;
import org.springframework.stereotype.Component;

@Component
public class HiServiceFallback implements FeignHiService {
    @Override
    public String hi() {
        return "Hi, Fall back";
    }
}
