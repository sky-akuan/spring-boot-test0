package com.akuan.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: FilterTest01
 * @Description: TODO
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午8:22
 * @version: V1.0
 */
public class FilterTest01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTest01.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTest01.doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FilterTest01.destroy");
    }
}
