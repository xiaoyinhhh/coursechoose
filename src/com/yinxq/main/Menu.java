package com.yinxq.main;

import com.yinxq.dao.TeacherMgrDao;
import com.yinxq.dao.TermMgrDao;
import com.yinxq.util.UserUtil;
import com.yinxq.view.*;

import java.util.Scanner;

public class Menu {
    //年级管理
    GradeMgrView gradeMgrView=new GradeMgrView();
    //学期管理
    TermMgrView termMgrView=new TermMgrView();
    //教室管理
    RoomMgrView roomMgrView=new RoomMgrView();
    //教师管理
    TeacherMgrView teacherMgrView=new TeacherMgrView();
    //学生管理
    StudentMgrView studentMgrView=new StudentMgrView();
    //课程管理
    CourseMgrView courseMgrView=new CourseMgrView();
    public static void main(String[] args) {
        new Menu().mainView();
    }

    public void  mainView(){
        System.out.println("-----------欢迎来到学生选课系统------------");
        System.out.println("-----------1.登录------------");
        System.out.println("-----------2.退出------------");
        System.out.println("请选择进行的操作：");

        //当通过new Scanner(System.in)创建一个Scanner，控制台会一直等待输入，直到敲回车键结束，把所输入的内容传给Scanner，作为扫描对象。如果要获取输入的内容，则只需要调用Scanner的nextLine()方法即可。
        Scanner sc=new Scanner(System.in);
        int ope=sc.nextInt();
        if(ope==1){
            //登录
            new UserView().login(sc);
            //判断登录结果
            if (UserUtil.user!=null){
                getMenu(sc);
            }
        }else  if(ope==2){
            //退出
        }
    }
    public void getMenu(Scanner sc){
        switch (UserUtil.user.getRoleId()){
            case 2:
                managerMenu(sc);
                break;
            case 3:
                teacherMenu(sc);
                break;
            case 4:
                studentrMenu(sc);
                break;
        }
    }
   //管理员菜单
    public void managerMenu(Scanner sc){
        System.out.println("---------欢迎【】进入学生选课系统----------");
        System.out.println("---------1、基础信息系统----------");
        System.out.println("---------------1.1、年级管理-------------");
        System.out.println("---------------1.2、学期管理-------------");
        System.out.println("---------------1.3、教室管理-------------");
        System.out.println("---------------1.4、教师管理-------------");
        System.out.println("---------------1.5、学生管理-------------");
        System.out.println("---------------1.6、课程管理-------------");
        System.out.println("----------2、排课-------------");
        System.out.println("请选择要进行的操作: ");
        String ope=sc.next();
        switch (ope){
            case "1.1":
                gradeMgr(sc);
                break;
            case "1.2":
                termMgr(sc);
                break;
            case "1.3":
                roomMgr(sc);
                break;
            case "1.4":
                teacherMgr(sc);
                break;
            case "1.5":
                studentMgr(sc);
                break;
            case "1.6":
                courseMgr(sc);
                break;
            case "2":
                break;
            default:
                break;
        }

    }
    //教师菜单
    public void teacherMenu(Scanner sc){
        System.out.println("---------欢迎【】进入学生选课系统----------");
        System.out.println("---------1、我的课表----------");
        System.out.println("请选择要进行的操作: ");
        String ope=sc.next();
        switch (ope){
            case "1":
                break;
            default:
                break;
        }

    }
    //学生菜单
    public void studentrMenu(Scanner sc){
        System.out.println("---------欢迎【】进入学生选课系统----------");
        System.out.println("---------1、选课----------");
        System.out.println("---------2、我的选课---------");
        System.out.println("请选择要进行的操作: ");
        String ope=sc.next();
        switch (ope){
            case "1":
                break;
            case "2":
                break;
            default:
                break;
        }
    }
    //年级管理
    public void gradeMgr(Scanner sc){
        System.out.println("-----------欢迎来到年级管理------------");
        System.out.println("----------1、查询年级-----------");
        System.out.println("----------2、添加年级-----------");
        System.out.println("----------3、修改年级-----------");
        System.out.println("----------4、删除年级-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                gradeMgrView.queryGrade();
                gradeMgr(sc);
                break;
            case 2:
                gradeMgrView.addGrade(sc);
                gradeMgr(sc);
                break;
            case 3:
                gradeMgrView.updateGrade(sc);
                gradeMgr(sc);
                break;
            case 4:
                gradeMgrView.deleteGrade(sc);
                gradeMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }
    //学期管理
    public void termMgr(Scanner sc) {
        System.out.println("-----------欢迎来到学期管理------------");
        System.out.println("----------1、查询学期-----------");
        System.out.println("----------2、添加学期-----------");
        System.out.println("----------3、修改学期-----------");
        System.out.println("----------4、删除学期-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                termMgrView.queryTerm();
                termMgr(sc);
                break;
            case 2:
                termMgrView.addTerm(sc);
                termMgr(sc);
                break;
            case 3:
                termMgrView.updateTerm(sc);
                termMgr(sc);
                break;
            case 4:
                termMgrView.deleteTerm(sc);
                termMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }
    //教室管理
    public void roomMgr(Scanner sc) {
        System.out.println("-----------欢迎来到教室管理------------");
        System.out.println("----------1、查询教室-----------");
        System.out.println("----------2、添加教室-----------");
        System.out.println("----------3、修改教室-----------");
        System.out.println("----------4、删除教室-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                roomMgrView.queryroomName();
                roomMgr(sc);
                break;
            case 2:
                roomMgrView.addRome(sc);
                roomMgr(sc);
                break;
            case 3:
                roomMgrView.updateRoom(sc);
                roomMgr(sc);
                break;
            case 4:
                roomMgrView.deleteRoom(sc);
                roomMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }
    //教师管理
    public void teacherMgr(Scanner sc) {
        System.out.println("-----------欢迎来到教师管理------------");
        System.out.println("----------1、查询教师-----------");
        System.out.println("----------2、添加教师-----------");
        System.out.println("----------3、修改教师-----------");
        System.out.println("----------4、删除教师-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                teacherMgrView.queryTeacher();
                teacherMgr(sc);
                break;
            case 2:
                teacherMgrView.addTeacher(sc);
                teacherMgr(sc);
                break;
            case 3:
                roomMgrView.updateRoom(sc);
                teacherMgr(sc);
                break;
            case 4:
                teacherMgrView.deleteTeacher(sc);
                teacherMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }
    //学生管理
    public void studentMgr(Scanner sc) {
        System.out.println("-----------欢迎来到学生管理------------");
        System.out.println("----------1、查询学生-----------");
        System.out.println("----------2、添加学生-----------");
        System.out.println("----------3、修改学生-----------");
        System.out.println("----------4、删除学生-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                studentMgrView.queryStudent();
                studentMgr(sc);
                break;
            case 2:
                studentMgrView.addStudent(sc);
                studentMgr(sc);
                break;
            case 3:
                studentMgrView.updateStudent(sc);
                studentMgr(sc);
                break;
            case 4:
                studentMgrView.deleteStudent(sc);
                studentMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }
    //课程管理
    public void courseMgr(Scanner sc) {
        System.out.println("-----------欢迎来到课程管理------------");
        System.out.println("----------1、查询课程-----------");
        System.out.println("----------2、添加课程-----------");
        System.out.println("----------3、修改课程-----------");
        System.out.println("----------4、删除课程-----------");
        System.out.println("----------5、回到上一级-----------");
        System.out.println("请选择要进行的操作: ");
        int ope=sc.nextInt();
        switch (ope){
            case 1:
                courseMgrView.queryCourse();
                courseMgr(sc);
                break;
            case 2:
                courseMgrView.addCourse(sc);
                courseMgr(sc);
                break;
            case 3:
                courseMgrView.updateCourse(sc);
                courseMgr(sc);
                break;
            case 4:
               courseMgrView.deleteTerm(sc);
                courseMgr(sc);
                break;
            case 5:
                managerMenu(sc);
                break;
        }
    }

}
