package com.akuan.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName: Listener01
 * @Description: Listener01
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午8:30
 * @version: V1.0
 */
public class Listener01 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Listener01.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Listener01.contextDestroyed");
    }
}
