package com.yinxq.view;

import com.yinxq.dao.StudentMgrDao;
import com.yinxq.dao.TeacherMgrDao;
import com.yinxq.dao.TermMgrDao;
import com.yinxq.entity.YGStudent;
import com.yinxq.entity.YGTeacher;
import com.yinxq.entity.YGUser;

import java.util.List;
import java.util.Scanner;

public class StudentMgrView {

    StudentMgrDao studentMgrDao=new StudentMgrDao();
    public void addStudent(Scanner sc){
        System.out.println("请输入用户名: ");
        String userName = sc.next();
        System.out.println("请输入密码: ");
        String pwd=sc.next();
        System.out.println("请输入学生编号: ");
        String studentNo=sc.next();
        System.out.println("请输入学生姓名: ");
        String studentName=sc.next();

        YGUser user=new YGUser();
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setRoleId(4);

        YGStudent student=new YGStudent();
        student.setStudentNo(studentNo);
        student.setStudentName(studentName);

        if (studentMgrDao.addStudent(user,student)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
    public void queryStudent(){
        System.out.println("学生列表如下: ");
        System.out.println("学生ID\t\t学生编号\t\t学生姓名\t\t用户编号");
        List<YGStudent> list=studentMgrDao.getStudent();
        list.forEach(item->{
            System.out.println(item.getId()+"\t\t"+item.getStudentNo()+"\t\t"+item.getStudentName()+"\t\t"+item.getUserId());
        });
    }
    public void updateStudent(Scanner sc){
        System.out.println("请输入要修改的用户名: ");
        int id=sc.nextInt();
        System.out.println("请输入要修改的密码: ");
        String termName=sc.next();
        System.out.println("请输入要修改的教师编号: ");
        int gradeId=sc.nextInt();
        System.out.println("请输入要修改的教师姓名: ");
        // String termName=sc.next();
        if (TermMgrDao.updateTerm(id,termName,gradeId)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
            updateStudent(sc);
        }
    }
    public void deleteStudent(Scanner sc){
        System.out.println("请输入要删除的学生ID: ");
        int studentId=sc.nextInt();
        //根据学生ID获取学生信息
        YGStudent student=studentMgrDao.getStudentById(studentId);

        if (studentMgrDao.deleteStudent(student)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
            deleteStudent(sc);
        }
    }
}
