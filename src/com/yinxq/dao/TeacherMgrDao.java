package com.yinxq.dao;

import com.yinxq.entity.KeyValue;
import com.yinxq.entity.YGClassRoom;
import com.yinxq.entity.YGTeacher;
import com.yinxq.entity.YGUser;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherMgrDao {
    public boolean addTeacher(YGUser user, YGTeacher teacher){
        List<KeyValue> list=new ArrayList<>();
        KeyValue kv1=new KeyValue();
        kv1.setKey("insert into yg_user(userName,pwd,roleId) values(?,?,?)");
        kv1.setValue(new Object[]{user.getUserName(),user.getPwd(),user.getRoleId()});

        KeyValue kv2=new KeyValue();
        kv2.setKey("insert into yg_teacher(teacherNo,teacherName,userID) values(?,?,LAST_INSERT_ID())");//mysql函数得到最新插入的自增长id
        kv2.setValue(new Object[]{teacher.getTeacherNo(),teacher.getTeacherName()});

        list.add(kv1);
        list.add(kv2);

        return DBUtil.transction(list)>0;//一次操作要往两个表里添加参数要使用事务，只要一次添加不成功就会回滚(要么都成功要么都失败)，如不使用事务则若添加一个表成功另一个表失败会形成脏数据
    }
    public boolean updateTeacher(YGUser user, YGTeacher teacher){
        List<KeyValue> list=new ArrayList<>();
        KeyValue kv1=new KeyValue();
        kv1.setKey("update yg_user set userName=?,pwd=?,roleId=? where id=?");
        kv1.setValue(new Object[]{user.getUserName(),user.getPwd(),user.getRoleId()});

        KeyValue kv2=new KeyValue();
        kv2.setKey("update yg_teacher set teacherNo,teacherName,userID) values(?,?,LAST_INSERT_ID())");//mysql函数得到最新插入的自增长id
        kv2.setValue(new Object[]{teacher.getTeacherNo(),teacher.getTeacherName()});

        list.add(kv1);
        list.add(kv2);

        return DBUtil.transction(list)>0;
    }
    public boolean deleteTeacher(int  id){
        String sql="delete from yg_classroom where id=?";
        return DBUtil.update(sql,id)>0;//返回受影响的行数
    }
    //获取年级列表
    public List<YGTeacher> getTeacher(){
        String sql="select *from yg_teacher";
        ResultSet rs=DBUtil.query(sql);
        List<YGTeacher> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGTeacher teacher=new YGTeacher();
                teacher.setId(rs.getInt("id"));
                teacher.setTeacherNo((rs.getNString("teacherNo")));
                teacher.setUserId(rs.getInt("userId"));
                teacher.setTeacherName((rs.getNString("teacherName")));
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
