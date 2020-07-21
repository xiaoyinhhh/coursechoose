package com.yinxq.view;

import com.yinxq.dao.UserDao;
import com.yinxq.entity.YGUser;
import com.yinxq.util.UserUtil;

import java.util.Scanner;

public class UserView {
    UserDao userDao=new UserDao();
    public void login(Scanner sc){
        System.out.println("请输入用户名: ");
        String userName=sc.next();
        System.out.println("请输入密码: ");
        String pwd=sc.next();
        System.out.println("请输入角色（2:管理员 3:教师 4:学生）: ");
        int roleId=sc.nextInt();

        YGUser user=new YGUser();
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setRoleId(roleId);
        //调用登录方法
        user=userDao.login(user);
        if(user.getId()!=0){
            System.out.println("登陆成功");
            UserUtil.user=user;
        }else {
            System.out.println("用户名、密码或角色错误！");
            login(sc);
        }
    }
}
