package com.subin.framework.ioc.classloader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: subiin
 * @date: 2018/1/15 下午10:40
 * @description:
 */
public class ClassLoaderServletTest extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ClassLoader loader = this.getClass().getClassLoader();
        while (loader != null) {
            out.write(loader.getClass().getName() + "<br/>");
            loader = loader.getParent();
        }
        out.write(String.valueOf(loader));
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
