package com.liuyanjun.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, ServletException, IOException {
        System.out.println("I am in AuthFilter-->doFilter()-before request go to servlet");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        System.out.println(" getRequestURL"+request.getRequestURI());
        System.out.println(" getScheme"+request.getScheme());
        System.out.println(" getServerName"+request.getServerName());
        System.out.println(" getServletPort"+request.getServerPort());
        System.out.println(" getRequestURI"+request.getRequestURI());
        System.out.println(" getServletPath"+request.getServletPath());
        System.out.println(" getQueryString"+request.getQueryString());
        System.out.println(" getMethod"+request.getMethod());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("I am in AuthFilter-->doFilter()-after servlet-response");
    }

    @Override
    public void destroy() {

    }
}
