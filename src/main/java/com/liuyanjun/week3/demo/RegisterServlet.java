package com.liuyanjun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//automatic -new-->servlet
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request come here -> <form method=post>
        //get parameter from requester
        String username= request.getParameter("Username");//name of input type -<input type="text" name="username">
        String password= request.getParameter("password");
        String email= request.getParameter("Email");
        String gender= request.getParameter("gender");
        String birthday= request.getParameter("Birthday");
        //print - write into response
        PrintWriter writer= response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>email:"+email);
        writer.println("<br>gender:"+gender);
        writer.println("<br>birthday:"+birthday);
        writer.close();
    }
}
