package com.liuyanjun.week6.deom;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tell tomcat this class is a listener class- how
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
   @Override
    public void contextInitialized(ServletContextEvent sce){
        //like a main() ,method for this web app
       //called when tomcat start
       //use this method to create jdbc connection when tomcat start
       ServletContext application = sce.getServletContext();
       String driver = application.getInitParameter("driver");
       String url = application.getInitParameter("url");
       String username = application.getInitParameter("username");
       String password = application.getInitParameter("Password");
       try {
           Class.forName(driver);
           Connection conn = DriverManager.getConnection(url, username, password);
           System.out.println("i am in contextInitialized()");//when?
           System.out.println("init()-->"+conn);
           //set connection a context attribute -- for all jsp and
           application.setAttribute("conn",conn);
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
       //end point of web app
        //this method called when tomcat stop
        System.out.println("i am in contextDestroyed()");//when this line print
        //remove connection from context
        sce.getServletContext().removeAttribute("conn");//name
    }
}
