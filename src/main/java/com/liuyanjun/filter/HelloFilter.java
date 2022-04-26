package com.liuyanjun.filter;

import javax.servlet.*;
import java.io.IOException;


import java.io.IOException;
import java.util.logging.Logger;

//@WebFilter("/hello")//url of servlet
public class HelloFilter implements Filter {

    static final Logger logger = Logger.getLogger(String.valueOf(HelloFilter.class));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("in HelloFilter->init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("in HelloFilter->doFilter()->before chain"+System.currentTimeMillis());
        filterChain.doFilter(servletRequest,servletResponse);
        logger.info("in HelloFilter->doFilter()->after chain"+System.currentTimeMillis());
    }

    @Override
    public void destroy() {
        logger.info("in HelloFilter->destroy()");
    }
}