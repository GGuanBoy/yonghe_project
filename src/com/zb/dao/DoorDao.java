package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoorDao {
    public List<Door> findAll() throws Exception {
        Connection conn =  DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door";
        PreparedStatement ps =conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Door door = null;
        List<Door> list = new ArrayList();
        while (rs.next()){
            door = new Door();
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));
            list.add(door);
        }
        conn.close();
        System.out.println(list);
        return list;
    }
    public void add(Door door) throws Exception {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_door values(null,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,door.getName());
        ps.setString(2,door.getTel());
        ps.setString(3,door.getAddr());
        ps.execute();
        conn.close();
    }
    public Door findById(Integer id){
        Door door = null;
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                door = new Door();
                door.setId(rs.getInt("id"));
                door.setName(rs.getString("name"));
                door.setTel(rs.getString("tel"));
                door.setAddr(rs.getString("addr"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return door;
    }
    public void updateById(Door door){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "update tb_door set name=?,tel=?,addr=? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,door.getName());
            ps.setString(2,door.getTel());
            ps.setString(3,door.getAddr());
            ps.setInt(4,door.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }
    public void deleteById(Integer id){
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "delete from tb_door where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public List<Door> showSale() {
        Connection conn = null;
        Door door = null;
        List<Door> list = null;
        try {
            conn = DBUtils.getConnectionByDatasource();
            String sql = "select name,sale from tb_door";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                door = new Door();
                door.setName(rs.getString("name"));
                door.setSale(rs.getString("sale"));
                list.add(door);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn);
        }
        return list;
    }
}
