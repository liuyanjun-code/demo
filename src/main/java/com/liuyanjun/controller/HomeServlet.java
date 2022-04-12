package com.liuyanjun.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "HomeServlet",value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//when you run  or click Home form menu - method is get to
        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request,response);
        //copy index.jsp inside WEB-INF/views
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
