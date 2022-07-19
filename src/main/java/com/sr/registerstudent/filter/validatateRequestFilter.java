package com.sr.registerstudent.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class validatateRequestFilter implements Filter {
    public  static final Logger logger = LoggerFactory.getLogger(validatateRequestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("inside filter class init method");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("inside filter class doFilter method");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("inside filter class destroy method");
        Filter.super.destroy();
    }
}
