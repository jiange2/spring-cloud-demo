package com.example.zuul.flter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class UserAccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // "pre" "route" "post" "error"
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
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String username = request.getParameter("username");

        if(StringUtils.isEmpty(username)){
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("username error!");
        }else{
            requestContext.setSendZuulResponse(true);
        }
        return null;
    }
}
