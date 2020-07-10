package com.zb.dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<Order> findAll(){
        Connection conn = null;
        List list = new ArrayList();
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from tb_order";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Order order =null;
            while(rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }

    public void add(Order order) {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "insert into tb_order set order_no=?,order_type=?,pnum=?,cashier=?,pay_type=?,price=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,order.getOrder_no());
            ps.setString(2,order.getOrder_type());
            ps.setInt(3,order.getPnum());
            ps.setString(4,order.getCashier());
            ps.setString(5,order.getPay_type());
            ps.setDouble(6,order.getPrice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order findById(Integer id) {
        Connection conn = null;
        Order order =null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select * from tb_order where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return order;
    }
    public void update(Order order){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update tb_order set order_no=?,order_type=?,pnum=?,cashier=?,pay_type=?,price=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,order.getOrder_no());
            ps.setString(2,order.getOrder_type());
            ps.setInt(3,order.getPnum());
            ps.setString(4,order.getCashier());
            ps.setString(5,order.getPay_type());
            ps.setDouble(6,order.getPrice());
            ps.setInt(7,order.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

    public void deleteById(Integer id) {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from tb_order where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
}
