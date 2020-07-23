package com.yinxq.view;

import com.yinxq.dao.ClassRoomMgrDao;
import com.yinxq.entity.YGClassRoom;
import com.yinxq.entity.YGGrade;

import java.util.List;
import java.util.Scanner;

public class RoomMgrView {
    ClassRoomMgrDao classRoomMgrDao=new ClassRoomMgrDao();
    public void addRome(Scanner sc) {
        System.out.println("请输入教室名称: ");
        String name = sc.next();
        if (classRoomMgrDao.addRoom(name)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
      public void queryroomName(){
            System.out.println("教室列表如下: ");
            System.out.println("教室ID\t\t教室名称");
            List<YGClassRoom> list=classRoomMgrDao.getRoom();
            list.forEach(item->{
                System.out.println(item.getId()+"\t\t"+item.getRoomName());
            });
        }
        public void updateRoom(Scanner sc){
            System.out.println("请输入要修改的教室ID: ");
            int id=sc.nextInt();
            System.out.println("请输入要修改的教室名称: ");
            String name=sc.next();
            if (classRoomMgrDao.updateRoom(name,id)){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
                updateRoom(sc);
            }
        }
        public void deleteRoom(Scanner sc){
            System.out.println("请输入要删除的年级ID: ");
            int id=sc.nextInt();
            if (classRoomMgrDao.deleteRoom(id)){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
                deleteRoom(sc);
            }
        }
    }
