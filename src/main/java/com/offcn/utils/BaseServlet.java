package com.offcn.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //需要知道访问的是哪个Servlet
        Class clazz = this.getClass();
        //需要知道访问的是哪个方法
        String method = req.getParameter("method");
        try {
            Method m = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            m.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
