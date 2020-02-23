package sdu.zeen.dao.impl;

import sdu.zeen.Utils;
import sdu.zeen.dao.UserDao;
import sdu.zeen.pojo.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User checkUserLoginDao(String user, String pwd) {
        //声明JDBC对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //声明变量
        User u=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn= Utils.getConnection();
            //创建sql命令
            String sql="select * from web201800301254_users where user=? and password =?";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,user);
            ps.setString(2,pwd);
            //执行sql
            rs=ps.executeQuery();
            //遍历结果
            while (rs.next())
            {
                u=new User();
                u.setUid(rs.getInt("ID"));
                u.setUser(rs.getString("user"));
                u.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            Utils.close(rs,ps,conn);
        }

        //返回结果
        return u;
    }
}
