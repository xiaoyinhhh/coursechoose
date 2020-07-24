package com.yinxq.view;

import com.yinxq.dao.CourseMgrDao;
import com.yinxq.dao.TermMgrDao;
import com.yinxq.entity.YGCourse;

import java.util.List;
import java.util.Scanner;

public class CourseMgrView {
    CourseMgrDao courseMgrDao=new CourseMgrDao();
    public void addCourse(Scanner sc){
        System.out.println("请输入课程编号: ");
        String couseNo=sc.next();
        System.out.println("请输入课程名称: ");
        String courseName=sc.next();
        System.out.println("请输入学分: ");
        double score=sc.nextDouble();
        System.out.println("请输入学时: ");
        double courseHour=sc.nextDouble();
        System.out.println("请输入学期: ");
        int termId=sc.nextInt();

        YGCourse course=new YGCourse();
        course.setCourseNo(couseNo);
        course.setCourseName(courseName);
        course.setScore(score);
        course.setCourseHour(courseHour);
        course.setTermId(termId);

        if (courseMgrDao.addCourse(course)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    public void queryCourse(){
        System.out.println("课程列表如下: ");
        System.out.println("课程ID\t\t课程编号\t\t课程名\t\t学分\t\t学时\t\t学期");
        List<YGCourse> list=courseMgrDao.getCourse();
        list.forEach(item->{
            System.out.println(item.getId()+"\t\t"+item.getCourseNo()+"\t\t"+item.getCourseName()+"\t\t"+item.getScore()+"\t\t"+item.getCourseHour()+"\t\t"+item.getTermId());
        });
    }
    public void updateCourse(Scanner sc){
        System.out.println("请输入要修改的课程ID: ");
        int id=sc.nextInt();
        System.out.println("请输入要修改的课程编号: ");
        String courseNo=sc.next();
        System.out.println("请输入要修改的课程名: ");
        String courseName=sc.next();
        System.out.println("请输入要修改的学分: ");
        double score=sc.nextDouble();
        System.out.println("请输入要修改的学时: ");
        double courseHour=sc.nextDouble();
        System.out.println("请输入要修改的学期: ");
        int termId=sc.nextInt();
        if (CourseMgrDao.updateCourse(courseNo,courseName,score,courseHour,termId,id)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
            updateCourse(sc);
        }
    }
    public void deleteTerm(Scanner sc){
        System.out.println("请输入要删除的课程ID: ");
        int id=sc.nextInt();
        if (courseMgrDao.deleteCourse(id)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
            deleteTerm(sc);
        }
    }
}
