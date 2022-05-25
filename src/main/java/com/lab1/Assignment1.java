package com.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifeCycleServlet",value = "/life")
public class Assignment1 extends HttpServlet {

    private int i = 0;

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        i++;//自加

        PrintWriter writer = response.getWriter();

        writer.println("<html><body>");
        writer.println("<h1>"+"Since loading,this servlet has been accessed"+i+"times"+"</h1>");
        writer.println("<body><html>");



    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("dectroy");
    }
}
