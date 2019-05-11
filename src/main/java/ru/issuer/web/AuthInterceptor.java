package ru.issuer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
        logger.info("request: {}, response: {}, handler: {}, exception: {}", request, response, handler, ex);
        super.afterCompletion(request, response, handler, ex);
    }
}
