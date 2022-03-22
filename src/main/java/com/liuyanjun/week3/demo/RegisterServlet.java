package com.liuyanjun.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//automatic -new-->servlet
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public void init() throws ServletException {
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
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//request come here -> <form method=post>
        //get parameter from requester
     /*   String username= request.getParameter("Username");//name of input type -<input type="text" name="username">
        String password= request.getParameter("password");
        String email= request.getParameter("Email");
        String gender= request.getParameter("gender");
        String birthday= request.getParameter("Birthday");
        //print - write into response

      */
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        /*
        out.print("<br> username :" + username);
        out.print("<br> password :" + password);
        out.print("<br> email :" + email);
        out.print("<br> gender :" + gender);
        out.print("<br> birth Date :" + birthday);
        out.close();
        */
        out.print("        <!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='UTF-8'>");
        out.print("        <title>UserList</title>");

        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1 align='center'>UserList</h1>");
        out.print("        <hr>");
        out.print("        <table border='1px' align='center' width='50%'>");
        out.print("            <tr>");
        out.print("                <th>ID</th>");
        out.print("                <th>UserName</th>");
        out.print("                <th>Password</th>");
        out.print("                <th>Email</th>");
        out.print("                <th>Gender</th>");
        out.print("                <th>Birthdate</th>");
        out.print("            </tr>");

        try {
          /*  String sql1 = "insert into usertable(Id, Username, Password, Email, Gender, Birthdate) values(?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, "1");
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, gender);
            ps.setString(6, birthday);
            int num = ps.executeUpdate();
            //out.print(num);

           */

            String sql2 = "select * from usertable";
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString("Id");
                String username2 = rs.getString("Username");
                String password2 = rs.getString("Password");
                String email2 = rs.getString("Email");
                String gender2 = rs.getString("Gender");
                String birthday2 = rs.getString("Birthdate");


                /* 以下是动态的 */
                out.print("            <tr>");
                out.print("                <td>"+ id +"</td>");
                out.print("                <td>"+ username2 +"</td>");
                out.print("                <td>"+ password2 +"</td>");
                out.print("                <td>"+ email2 +"</td>");
                out.print("                <td>"+ gender2 +"</td>");
                out.print("                <td>"+ birthday2 +"</td>");
                out.print("            </tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

        /* 以下是固定的 */
        out.print("        </table>");
        out.print("        <hr>");
        out.print("    </body>");
        out.print("</html>");

        out.close();
    }
}
