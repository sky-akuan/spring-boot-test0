package com.akuan.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName: FilterTest02
 * @Description: FilterTest02
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午8:22
 * @version: V1.0
 */
@WebFilter(urlPatterns = "/filter02/*",description = "filter 测试")
public class FilterTest02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterTest02.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterTest02.doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("FilterTest02.destroy");
    }
}
