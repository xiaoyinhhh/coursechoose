package com.yinxq.view;

import com.yinxq.dao.GradeMgrDao;
import com.yinxq.entity.YGGrade;

import java.util.List;
import java.util.Scanner;

public class GradeMgrView {
    GradeMgrDao gradeMgrDao=new GradeMgrDao();
    public void addGrade(Scanner sc){
        System.out.println("请输入年级名称: ");
        String name=sc.next();
        //添加到数据库中
        if (gradeMgrDao.addGrade(name)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
            addGrade(sc);
        }
    }
    public void queryGrade(){
        System.out.println("年级列表如下: ");
        System.out.println("年级ID\t\t年级名称");
        List<YGGrade> list=gradeMgrDao.getGrades();
        list.forEach(item->{
            System.out.println(item.getId()+"\t\t"+item.getGradeName());
        });
    }
    public void updateGrade(Scanner sc){
        System.out.println("请输入要修改的年级ID: ");
        int id=sc.nextInt();
        System.out.println("请输入要修改的年级名称: ");
        String name=sc.next();
        if (gradeMgrDao.updateGrade(name,id)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
            addGrade(sc);
        }
    }
    public void deleteGrade(Scanner sc){
        System.out.println("请输入要删除的年级ID: ");
        int id=sc.nextInt();
        if (gradeMgrDao.deleteGrade(id)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
            addGrade(sc);
        }
    }
}
