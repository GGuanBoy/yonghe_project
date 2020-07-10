package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderDelete")
public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        OrderDao dao = new OrderDao();
        dao.deleteById(id);
        resp.sendRedirect(req.getContextPath()+"/orderList");
    }
}
