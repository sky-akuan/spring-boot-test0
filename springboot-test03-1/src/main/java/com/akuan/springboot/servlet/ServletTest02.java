package com.akuan.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ServletTest02
 * @Description: ServletTest02
 * @author: zhaozhenkuan
 * @date: 2017-08-02 下午8:14
 * @version: V1.0
 */
@WebServlet(urlPatterns = "/servlet02/*",description = "servlet test")
public class ServletTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest02.doGet");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletTest02.doPost");
        super.doPost(req, resp);
    }
}
