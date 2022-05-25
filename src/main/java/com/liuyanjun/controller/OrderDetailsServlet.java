package com.liuyanjun.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.liuyanjun.dao.OrderDao;
import com.liuyanjun.model.Item;
import com.liuyanjun.model.Order;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("conn");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item = new Item();
        OrderDao dao = new OrderDao();
        List<Item> itemList = dao.findItemsByOrderId(con, orderId);
        request.setAttribute("itemList", itemList);
        String path = "orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}