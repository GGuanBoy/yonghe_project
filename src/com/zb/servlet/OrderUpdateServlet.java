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

@WebServlet("/orderUpdate")
public class OrderUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String order_no = req.getParameter("order_no");
        String order_type = req.getParameter("order_type");
        Integer pnum  = Integer.parseInt(req.getParameter("pnum"));
        String cashier = req.getParameter("cashier");
        String pay_type = req.getParameter("pay_type");
        Double price =Double.parseDouble(req.getParameter("price"));
        String p_time = req.getParameter("pay_time");
        Date pay_time = Str2Date.str2date(p_time);
        Order order = new Order();
        order.setId(id);
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setPay_type(pay_type);
        order.setPrice(price);
        order.setPay_time(pay_time);
        OrderDao dao = new OrderDao();
        dao.update(order);
        resp.sendRedirect(req.getContextPath()+"/orderList");
    }
}
