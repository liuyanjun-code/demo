package com.liuyanjun.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import com.liuyanjun.dao.ProductDao;
import com.liuyanjun.model.Category;
import com.liuyanjun.model.Product;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = request.getParameter("id")!=null?Integer.parseInt(request.getParameter("id")):0;
        ProductDao productDao = new ProductDao();
        if (id == 0){
            return; //error
        }
        List<Category> categoryList = Category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);

        try {
            Product product = productDao.findById(id, con);
            request.setAttribute("p", product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
