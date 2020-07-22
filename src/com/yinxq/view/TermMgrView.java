package com.yinxq.view;

import com.yinxq.dao.TermMgrDao;
import com.yinxq.entity.YGGrade;
import com.yinxq.entity.YGTerm;

import java.util.List;
import java.util.Scanner;

public class TermMgrView {
    TermMgrDao termMgrDao=new TermMgrDao();
    public void addTerm(Scanner sc){
        System.out.println("请输入年级ID: ");
        int gradeId=sc.nextInt();
        System.out.println("请输入学期名称: ");
        String name=sc.next();
        //添加到数据库中
        if (termMgrDao.addTerm(gradeId,name)){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
            addTerm(sc);
        }
    }
    public void queryTerm(){
        System.out.println("学期列表如下: ");
        System.out.println("学期ID\t\t年级ID\t\t学期名称");
        List<YGTerm> list=termMgrDao.getTerm();
        list.forEach(item->{
            System.out.println(item.getId()+"\t\t"+item.getGradeId()+"\t\t"+item.getTermName());
        });
    }
    public void updateTerm(Scanner sc){
        System.out.println("请输入要修改的学期ID: ");
        int id=sc.nextInt();
        System.out.println("请输入要修改的学期名称: ");
        String termName=sc.next();
        System.out.println("请输入要修改的年级名称: ");
        int gradeId=sc.nextInt();
        if (TermMgrDao.updateTerm(id,termName,gradeId)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
            updateTerm(sc);
        }
    }
    public void deleteTerm(Scanner sc){
        System.out.println("请输入要删除的年级ID: ");
        int id=sc.nextInt();
        if (termMgrDao.deleteTerm(id)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
            deleteTerm(sc);
        }
    }
}