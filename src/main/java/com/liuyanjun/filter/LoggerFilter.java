package com.liuyanjun.filter;



import javax.servlet.*;
import java.io.IOException;


public class LoggerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("I am in LoggerFilter-->doFilter()-before request go to servlet");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("I am in LoggerFilter-->doFilter()-after servlet-response");
    }

    @Override
    public void destroy() {

    }
}
