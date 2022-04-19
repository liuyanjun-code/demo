package com.liuyanjun.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "UpadteUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code
        //TODO 1:forward to WEB-INF/views/upadte.jsp
        //TODO 2:create one jsp page-update User
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code to update user info -can update password.email,gender,birthdate
        //TODO 1:get all (6) request parameters
        //TODO 2:creat an object of User Model
        //TODO 3:set all 6 request parameters values into User model -setXXX()
        //TODO 4:create an object of UserDao
        //TODO 5:call upadteUser() in UserDao
        //TODO 6:forward to WEB-INF/view/userInfo.jsp
    }
}
