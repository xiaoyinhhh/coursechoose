package com.yinxq.dao;

import com.yinxq.entity.YGGrade;
import com.yinxq.entity.YGTerm;
import com.yinxq.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TermMgrDao {
    public boolean addTerm(int gradeId, String name) {
        String sql = "insert into yg_term(termName,gradeId) values(?,?)";
        Object[] params = {name, gradeId};
        return DBUtil.update(sql, params) > 0;
    }
    public static boolean updateTerm(int id, String termnNme, int gradeId){
        String sql="update yg_term set termName=?,gradeId=? where id=?";
        Object[] params={termnNme,id,gradeId};
        return DBUtil.update(sql,params)>0;//返回受影响的行数
    }
    public boolean deleteTerm(int  id){
        String sql="delete from yg_term where id=?";
        return DBUtil.update(sql,id)>0;//返回受影响的行数
    }
    //获取年级列表
    public List<YGTerm> getTerm(){
        String sql="select *from yg_term";
        ResultSet rs=DBUtil.query(sql);
        List<YGTerm> list=new ArrayList<>();
        try {
            while (rs.next()){
                YGTerm term=new YGTerm();
                term.setId(rs.getInt("id"));
                term.setTermName((rs.getNString("termName")));
                term.setGradeId(rs.getInt("gradeId"));
                list.add(term);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

