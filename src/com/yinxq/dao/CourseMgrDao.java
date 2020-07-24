package com.yinxq.dao;

import com.yinxq.entity.YGCourse;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseMgrDao {
    public boolean addCourse(YGCourse course){
        String sql="insert into yg_course(courseNo,courseName,score,courseHour,termId) values(?,?,?,?,?)";
        Object[] params={course.getCourseNo(),course.getCourseName(),course.getScore(),course.getCourseHour(),course.getTermId()};
        return DBUtil.update(sql,params)>0;
    }
    public static boolean updateCourse(String courseNo, String courseName,double score,double courseHour,int termId,int id){
        String sql="update yg_course set courseNo=?,courseName=?,score=?,courseHour=?,termId=? where id=?";
        Object[] params={courseNo,courseName,score,courseHour,termId,id};
        return DBUtil.update(sql,params)>0;//返回受影响的行数
    }
    public boolean deleteCourse(int  id){
        String sql="delete from yg_course where id=?";
        return DBUtil.update(sql,id)>0;//返回受影响的行数
    }
    //获取年级列表
    public List<YGCourse> getCourse(){
        String sql="select *from yg_course";
        ResultSet rs=DBUtil.query(sql);
        List<YGCourse> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGCourse course=new YGCourse();
                course.setCourseNo(rs.getNString("courseNo"));
                course.setCourseName(rs.getNString("courseName"));
                course.setId(rs.getInt("id"));
                course.setCourseHour(rs.getDouble("courseHour"));
                course.setTermId(rs.getInt("termId"));
                course.setScore(rs.getDouble("score"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
