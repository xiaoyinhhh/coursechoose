package com.yinxq.dao;

import com.yinxq.entity.YGGrade;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeMgrDao {
    public boolean addGrade(String name){
        String sql="insert into yg_grade(gradeName) values(?)";
        return DBUtil.update(sql,name)>0;//返回受影响的行数
    }
    public boolean updateGrade(String name,int  id){
        String sql="update yg_grade set gradeName=? where id=?";
        Object[] params={name,id};
        return DBUtil.update(sql,params)>0;//返回受影响的行数
    }
    public boolean deleteGrade(int  id){
        String sql="delete from yg_grade where id=?";
        return DBUtil.update(sql,id)>0;//返回受影响的行数
    }
    //获取年级列表
    public List<YGGrade> getGrades(){
        String sql="select *from yg_grade";
        ResultSet rs=DBUtil.query(sql);
        List<YGGrade> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGGrade grade=new YGGrade();
                grade.setId(rs.getInt("id"));
                grade.setGradeName((rs.getNString("gradeName")));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
