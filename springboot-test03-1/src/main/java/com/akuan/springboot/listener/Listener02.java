package com.akuan.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName: Listener02
 * @Description: Listener02
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午8:30
 * @version: V1.0
 */
@WebListener
public class Listener02 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Listener02.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Listener02`.contextDestroyed");
    }
}
