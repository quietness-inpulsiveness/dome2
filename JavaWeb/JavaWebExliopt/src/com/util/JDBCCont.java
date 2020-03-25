package com.util;

import java.sql.*;

public class JDBCCont {
    static final String URL="jdbc:mysql://localhost/shopdb?useSSL=FALSE&serverTimezone=UTC";
    static  final String USER="root";
    static final String PASS = "670063744";
    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void colseAll(Connection conn,PreparedStatement pst,ResultSet rs){
        if (conn!=null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (pst!=null)
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (rs!=null)
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
//   public static void main(String[] args) {
//       Connection conn = JDBCCont.getConn();
//       PreparedStatement pst = null;
//       ResultSet rs = null;
//       try {
//           String sql = "select * from t_user";
//           pst = conn.prepareStatement(sql);
//           rs = pst.executeQuery(sql);
//           while(rs.next()){
//               System.out.print(rs.getInt("id")+rs.getString("name"));
//           }
//       } catch (SQLException e) {
//           e.printStackTrace();
//       } finally {
//           JDBCCont.colseAll(conn,pst,rs);
//       }

}
