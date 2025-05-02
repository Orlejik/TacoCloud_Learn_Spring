package com.art.demo4.Configuration;

//The class for logging the URLs which you try to access for better debugging the issue with ACCESS DENIED error on user login and try to add ingredients to Taco


import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class UrlLogginfFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURL().toString();
        System.out.println("Request URL: " + requestURI);
        filterChain.doFilter(request, response);
    }
}

