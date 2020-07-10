package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;
import com.zb.utils.Str2Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDao dao = new OrderDao();
        List list = dao.findAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("order_list.jsp").forward(req,resp);
    }
}
