package com.liuyanjun.week5.demo;


import com.liuyanjun.dao.UserDao;
import com.liuyanjun.model.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*
        ServletContext application = getServletConfig().getServletContext();
        String driver = application.getInitParameter("driver");
        String url = application.getInitParameter("url");
        String username = application.getInitParameter("Username");
        String password = application.getInitParameter("Password");

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         */
        //only one line here
        conn = (Connection) getServletContext().getAttribute("conn");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        //response.setContentType("text/html;charset=UTF-8");

        //now move jdbc in dao-mvc design
        //write mvc code
        //use model and dao
        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(conn,username,password);//use for login
            if (user!=null){
                //valid
                //set user into request
                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");//1=checked null if checked
                if(rememberMe!=null&&rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);//5 sec just for test---15 days ==60*60*24*15
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                //invalid
                request.setAttribute("meassage","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //forward jsp

        String sql = "Select ID,username,password,email,gender,birthdate from userdb where username="+username+" and password="+password;
        try {
            ResultSet rs=conn.createStatement().executeQuery(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                //week5 code
                //out.print("Login Success!!! <br>");
                //out.print("Welcome,"+ username +" <br>");
                //get from rs and set into request attribute
                request.setAttribute("Id",rs.getInt("id"));
                request.setAttribute("Username",rs.getString("username"));
                request.setAttribute("Password",rs.getString("password"));
                request.setAttribute("Email",rs.getString("email"));
                request.setAttribute("Gender",rs.getString("gender"));
                request.setAttribute("Birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }else{
                //out.print("Login Error!!! <br>");
                request.setAttribute("meassage","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
