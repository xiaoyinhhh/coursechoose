package com.yinxq.dao;

import com.yinxq.entity.YGClassRoom;
import com.yinxq.entity.YGGrade;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomMgrDao {
    public boolean addRoom(String roomName){
        String sql="insert into yg_classroom(roomName) values(?)";
        return DBUtil.update(sql,roomName)>0;
    }
    public boolean updateRoom(String roomName,int  id){
        String sql="update yg_classroom set roomName=? where id=?";
        Object[] params={roomName,id};
        return DBUtil.update(sql,params)>0;//返回受影响的行数
    }
    public boolean deleteRoom(int  id){
        String sql="delete from yg_classroom where id=?";
        return DBUtil.update(sql,id)>0;//返回受影响的行数
    }
    //获取年级列表
    public List<YGClassRoom> getRoom(){
        String sql="select *from yg_classroom";
        ResultSet rs=DBUtil.query(sql);
        List<YGClassRoom> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGClassRoom classRoom=new YGClassRoom();
                classRoom.setId(rs.getInt("id"));
                classRoom.setRoomName((rs.getNString("roomName")));
                list.add(classRoom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
