package com.example.zuul.flter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        throw new ZuulException("error", HttpStatus.BAD_GATEWAY.value(),"error");
        //return null;
    }
}
