package com.liuyanjun.week5.demo;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sql = "Select ID,Username,Password,Email,Gender,birthdate from userdb where username="+username+" and password="+password;
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
