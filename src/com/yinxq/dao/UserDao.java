package com.yinxq.dao;

import com.yinxq.entity.YGUser;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public YGUser login(YGUser user) {
        String sql="select *from yg_user where userName=? and pwd=? and roleId=?";
        Object[] params={ user.getUserName(),user.getPwd(),user.getRoleId()};
        //结果集(ResultSet)是数据中查询结果返回的一种对象,可以说结果集是一个存储查询结果的对象,但是结果集并不仅仅具有存储的功能,他同时还具有操纵数据的功能,可能完成对数据的更新等
        // 当我们查询数据库时，返回的是一个二维的结果集，我们这时候需要使用 ResultSet 来遍历结果集，获取每一行的数据。
        ResultSet rs= DBUtil.query(sql,params);
        try {
            while(rs.next()){
               //getColumnLabel() : 返回结果集列的别名（有别名获取别名，没别名获取列名）
                user.setId(rs.getInt("id"));//查询到则id为其所对应id否则默认为0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;//成功则传入user的id属性有值失败则id属性依然为0
    }
}
