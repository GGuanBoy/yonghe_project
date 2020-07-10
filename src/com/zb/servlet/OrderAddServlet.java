package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderAdd")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_no = req.getParameter("order_no");
        String order_type = req.getParameter("order_type");
        Integer pnum  = Integer.parseInt(req.getParameter("pnum"));
        String cashier = req.getParameter("cashier");
        String pay_type = req.getParameter("pay_type");
        Double price =Double.parseDouble(req.getParameter("price"));
        Order order = new Order();
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setPay_type(pay_type);
        order.setPrice(price);
        OrderDao dao = new OrderDao();
        dao.add(order);
        resp.sendRedirect(req.getContextPath()+"/orderList");
    }
}
