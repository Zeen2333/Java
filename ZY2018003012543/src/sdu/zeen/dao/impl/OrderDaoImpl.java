package sdu.zeen.dao.impl;

import sdu.zeen.Utils;
import sdu.zeen.dao.OrderDao;
import sdu.zeen.pojo.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderDaoImpl implements OrderDao {

    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    Order o=null;
    ArrayList<Order> ao=null;

    @Override
    public ArrayList<Order> checkOrderDao(int userID) throws SQLException {
        conn= Utils.getConnection();
        String sql="select * from web201800301254_orders where userID = ?";
        //创建sql命令对象
        ps=conn.prepareStatement(sql);
        ps.setInt(1,userID);
        //执行sql
        rs=ps.executeQuery();
        //遍历结果
        ao=new ArrayList<>();
        while (rs.next())
        {
            o= new Order(rs.getInt("userID"),rs.getString("date"));
            o.setNum1(rs.getInt("num1"));
            o.setNum2(rs.getInt("num2"));
            o.setNum3(rs.getInt("num3"));
            o.setNum4(rs.getInt("num4"));
            ao.add(o);
        }
        return ao;
    }

    @Override
    public void addOrderDao(int userID) throws SQLException {
        conn= Utils.getConnection();
        String sql="select * from web201800301254_shoppingCart where userID = ?";
        //创建sql命令对象
        ps=conn.prepareStatement(sql);
        ps.setInt(1,userID);
        //执行sql
        rs=ps.executeQuery();
        //遍历结果
        while (rs.next())
        {
            String date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            o= new Order(rs.getInt("userID"),date);
            o.setNum1(rs.getInt("num1"));
            o.setNum2(rs.getInt("num2"));
            o.setNum3(rs.getInt("num3"));
            o.setNum4(rs.getInt("num4"));
        }
        String sql2="insert into web201800301254_orders values (?,?,?,?,?,?)";
        ps=conn.prepareStatement(sql2);
        ps.setInt(1,o.getNum1());
        ps.setInt(2,o.getNum2());
        ps.setInt(3,o.getNum3());
        ps.setInt(4,o.getNum4());
        ps.setInt(5,o.getUserID());
        ps.setString(6,o.getDate());
        ps.execute();
        String sql3="update web201800301254_shoppingCart set num1=0,num2=0,num3=0,num4=0 where userID = ?";
        ps=conn.prepareStatement(sql3);
        ps.setInt(1,userID);
        ps.execute();
    }

}
