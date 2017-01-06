package com.weker.nvwa.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 登录
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 07/12/2016
 */
public class SsoFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(SsoFilter.class);

    /**
     * http request header 中识别token
     */
    private final static String TOKEN_HEADER = "token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        ServletContext context = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
