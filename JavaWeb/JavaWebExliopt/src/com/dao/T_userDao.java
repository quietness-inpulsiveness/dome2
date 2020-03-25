package com.dao;

import com.entity.T_user;
import com.util.JDBCCont;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class T_userDao {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String sql;

    /***
     * 获取 所有用户信息
     * @return list<T_user></>
     */
    public List<T_user> getAllT_user(){
    List<T_user> users = new ArrayList<>();
    T_user user;
    sql="select * from T_user";
    conn= JDBCCont.getConn();
        try {
            pst= conn.prepareStatement(sql);
            rs =pst.executeQuery(sql);
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String trueName = rs.getString("trueName");
                String cardId = rs.getString("cardId");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String qqId = rs.getString("qqId");
                String pwd = rs.getString("pwd");
                String regTime = rs.getString("regTime");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                int state = rs.getInt("state");
                user=new T_user(id, name,trueName,cardId,  email,telephone, qqId,  pwd, regTime, question, answer, state);
                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCont.colseAll(conn,pst,rs);
        }
        return users;
    }

    /***
     * 添加用户T_user
     * @param user 传递的用户信息
     * @return 成功为1 不成功为0
     */
    public int addT_user(T_user user){
        int result=0;
        sql="INsert into T_user (name,trueName,cardId,email,telephone,qqId)values(?,?,?,?,?,?)";
        try {
            conn=JDBCCont.getConn();
            pst=conn.prepareStatement(sql);
            pst.setString(1,user.getName());
            pst.setString(2,user.getTrueName());
            pst.setString(3,user.getCardId());
            pst.setString(4,user.getEmail());
            pst.setString(5,user.getTelephone());
            pst.setString(6,user.getQqId());
            result=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCont.colseAll(conn,pst,rs);
        }
        return result;
    }

    /***
     * 获取单个用户信息
     * @param id 用户id
     * @return 一个用户
     */
    public T_user getT_user(int id){
        T_user user=null;
        sql="select * from T_user where id=?";
        conn=JDBCCont.getConn();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next())
            {
                String name = rs.getString("name");
                String trueName = rs.getString("trueName");
                String cardId = rs.getString("cardId");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String qqId = rs.getString("qqId");
                String pwd = rs.getString("pwd");
                String regTime = rs.getString("regTime");
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                int state = rs.getInt("state");
                user=new T_user(id, name,trueName,cardId,  email,telephone, qqId,  pwd, regTime, question, answer, state);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCont.colseAll(conn,pst,rs);
        }
        return user;
    }
    public int DelT_user(String idList){
        int restult=0;
        sql="delete from T_user where id in ("+idList+")";
        conn=JDBCCont.getConn();
        try {
            pst=conn.prepareStatement(sql);
            restult = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCCont.colseAll(conn,pst,rs);
        }
    return restult;
    }
}
