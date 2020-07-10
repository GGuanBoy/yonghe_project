package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorInfo")
public class DoorInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id =Integer.parseInt(req.getParameter("id"));
        DoorDao dao = new DoorDao();
        Door door = dao.findById(id);
        req.setAttribute("door",door);
        req.getRequestDispatcher("door_update.jsp").forward(req,resp);
    }
}
