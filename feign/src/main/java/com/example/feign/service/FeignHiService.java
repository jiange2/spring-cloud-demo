package com.example.feign.service;

import com.example.feign.fallback.HiServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import service.HiService;

@FeignClient(value = "hi-service",fallback = HiServiceFallback.class)
public interface FeignHiService extends HiService {
}
