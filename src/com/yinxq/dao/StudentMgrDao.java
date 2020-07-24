package com.yinxq.dao;

import com.yinxq.entity.KeyValue;
import com.yinxq.entity.YGStudent;
import com.yinxq.entity.YGTeacher;
import com.yinxq.entity.YGUser;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMgrDao {
    //根据Id获取用户信息
    public YGStudent getStudentById(int id){
        String sql="select *from yg_student where id=?";
        ResultSet rs=DBUtil.query(sql,id);
        YGStudent student=null;
        try {
           while(rs.next()){
               student=new YGStudent();
               student.setId(id);
               student.setUserId(rs.getInt("userId"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public boolean addStudent(YGUser user, YGStudent student){
        List<KeyValue> list=new ArrayList<>();
        KeyValue kv1=new KeyValue();
        kv1.setKey("insert into yg_user(userName,pwd,roleId) values(?,?,?)");
        kv1.setValue(new Object[]{user.getUserName(),user.getPwd(),user.getRoleId()});

        KeyValue kv2=new KeyValue();
        kv2.setKey("insert into yg_student(studentNo,studentName,userID) values(?,?,LAST_INSERT_ID())");//mysql函数得到最新插入的自增长id
        kv2.setValue(new Object[]{student.getStudentNo(),student.getStudentName()});

        list.add(kv1);
        list.add(kv2);

        return DBUtil.transction(list)>0;//一次操作要往两个表里添加参数要使用事务，只要一次添加不成功就会回滚(要么都成功要么都失败)，如不使用事务则若添加一个表成功另一个表失败会形成脏数据
    }
    public boolean updateTeacher(int id,String teacherNo,String teacherName){
        String sql="update yg_teacher set teacherNo=?,teacherName=? where id=?";
        Object[] params={teacherNo,id,teacherName};
        return DBUtil.update(sql,params)>0;
    }
    public boolean deleteStudent(YGStudent student){
        List<KeyValue> list=new ArrayList<>();
        KeyValue kv1=new KeyValue();
        kv1.setKey("delete from yg_student where id=?");
        kv1.setValue(new Object[]{student.getId()});

        KeyValue kv2=new KeyValue();
        kv2.setKey("delete from yg_user where id=?");     //mysql函数得到最新插入的自增长id
        kv2.setValue(new Object[]{student.getUserId()});

        list.add(kv1);
        list.add(kv2);

        return DBUtil.transction(list)>0;
    }
    //获取年级列表
    public List<YGStudent> getStudent(){
        String sql="select *from yg_student";
        ResultSet rs=DBUtil.query(sql);
        List<YGStudent> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGStudent student=new YGStudent();
                student.setId(rs.getInt("id"));
                student.setStudentNo((rs.getNString("studentNo")));
                student.setUserId(rs.getInt("userId"));
                student.setStudentName((rs.getNString("studentName")));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
