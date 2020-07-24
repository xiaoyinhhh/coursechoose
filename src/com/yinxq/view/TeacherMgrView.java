package com.yinxq.view;

import com.yinxq.dao.TeacherMgrDao;
import com.yinxq.dao.TermMgrDao;
import com.yinxq.entity.YGClassRoom;
import com.yinxq.entity.YGTeacher;
import com.yinxq.entity.YGTerm;
import com.yinxq.entity.YGUser;

import java.util.List;
import java.util.Scanner;

public class TeacherMgrView {
    TeacherMgrDao teacherMgrDao=new TeacherMgrDao();
    public void addTeacher(Scanner sc){
        System.out.println("请输入用户名: ");
        String userName = sc.next();
        System.out.println("请输入密码: ");
        String pwd=sc.next();
        System.out.println("请输入教师编号: ");
        String teacherNo=sc.next();
        System.out.println("请输入教师姓名: ");
        String teacherName=sc.next();

        YGUser user=new YGUser();
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setRoleId(3);

        YGTeacher teacher=new YGTeacher();
        teacher.setTeacherNo(teacherNo);
        teacher.setTeacherName(teacherName);

        if (teacherMgrDao.addTeacher(user,teacher)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
    public void queryTeacher(){
        System.out.println("教师列表如下: ");
        System.out.println("教师ID\t\t教师编号\t\t教师姓名\t\t用户编号");
        List<YGTeacher> list=teacherMgrDao.getTeacher();
        list.forEach(item->{
            System.out.println(item.getId()+"\t\t"+item.getTeacherNo()+"\t\t"+item.getTeacherName()+"\t\t"+item.getUserId());
        });
    }
    public void updateTeacher(Scanner sc){
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
            updateTeacher(sc);
        }
    }
    public void deleteTeacher(Scanner sc){
        System.out.println("请输入要删除的教师ID: ");
        int id=sc.nextInt();
       if (teacherMgrDao.deleteTeacher(id)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
            deleteTeacher(sc);
        }
    }
}
