package com.liuyanjun.controller;

import com.liuyanjun.dao.UserDao;
import com.liuyanjun.model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");

        User user = new User();
        user.setID(String.valueOf(Integer.valueOf(id)));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        // 这里的Date.valueOf()是java.sql.Date类的方法，而User中的Date类是java.util.Date
        // java.sql.Date类是继承java.util.Date类的，等于这里使用了向上转型
        user.setBirthDate(Date.valueOf(birthday));

        UserDao userDao = new UserDao();
        int num = 0;
        try {
            num = userDao.updateUser(con, user);
            User updateUser = userDao.findById(con, id);
            if (num != 0){
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                session.setAttribute("user", updateUser);
                request.getRequestDispatcher("accountDetails").forward(request, response);
            }else {
                request.setAttribute("message", "Update fail!");
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
