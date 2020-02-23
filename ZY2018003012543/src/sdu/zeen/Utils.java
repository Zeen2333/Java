package sdu.zeen;

import java.sql.*;


public class Utils {

    public static Connection getConnection() throws SQLException {
        Connection conn=null;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://202.194.14.120:3306/webteach";
        String user="webteach";
        String password="webteach";

        try {
            Class.forName(driver);//加载驱动
            conn = DriverManager.getConnection(url,user,password);//建立连接
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
