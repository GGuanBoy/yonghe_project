package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorUpdate")
public class DoorUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String addr = req.getParameter("addr");
        Door door = new Door();
        door.setId(id);
        door.setName(name);
        door.setTel(tel);
        door.setAddr(addr);
        DoorDao dao = new DoorDao();
        dao.updateById(door);
        resp.sendRedirect("/doorList");
    }
}
