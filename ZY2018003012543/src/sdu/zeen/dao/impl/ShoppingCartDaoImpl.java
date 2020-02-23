package sdu.zeen.dao.impl;

import sdu.zeen.Utils;
import sdu.zeen.dao.ShoppingCartDao;
import sdu.zeen.pojo.Product;
import sdu.zeen.pojo.ShoppingCart;

import java.sql.*;
import java.util.ArrayList;

public class ShoppingCartDaoImpl implements ShoppingCartDao {

    //声明JDBC对象
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    ShoppingCart sc=null;

    @Override
    public ShoppingCart checkShoppingCartDao(int userID) throws SQLException {
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
            sc= new ShoppingCart(rs.getInt("userID"));
            sc.setNum1(rs.getInt("num1"));
            sc.setNum2(rs.getInt("num2"));
            sc.setNum3(rs.getInt("num3"));
            sc.setNum4(rs.getInt("num4"));
        }
        return sc;
    }

    @Override
    public ShoppingCart addProductDao(int ID, int userID) throws SQLException {
        conn= Utils.getConnection();
        String sql="";
        int num=0;
        switch (ID) {
            case 1:
                sql = "update web201800301254_shoppingCart set num1 = ? where userID = ?";
                num = checkShoppingCartDao(userID).getNum1();
                break;
            case 2:
                sql = "update web201800301254_shoppingCart set num2 = ? where userID = ?";
                num = checkShoppingCartDao(userID).getNum2();
                break;
            case 3:
                sql = "update web201800301254_shoppingCart set num3 = ? where userID = ?";
                num = checkShoppingCartDao(userID).getNum3();
                break;
            case 4:
                sql = "update web201800301254_shoppingCart set num4 = ? where userID = ?";
                num = checkShoppingCartDao(userID).getNum4();
                break;
        }
        //创建sql命令对象
        ps=conn.prepareStatement(sql);
        ps.setInt(1,num+1);
        ps.setInt(2,userID);
        //执行sql
        ps.execute();
        //遍历结果
        return checkShoppingCartDao(userID);
    }

    @Override
    public ShoppingCart deleteProductDao(int ID, int userID) throws SQLException {
        conn= Utils.getConnection();
        String sql="";;
        switch (ID) {
            case 1:
                sql = "update web201800301254_shoppingCart set num1 = 0 where userID = ?";
                break;
            case 2:
                sql = "update web201800301254_shoppingCart set num2 = 0 where userID = ?";
                break;
            case 3:
                sql = "update web201800301254_shoppingCart set num3 = 0 where userID = ?";
                break;
            case 4:
                sql = "update web201800301254_shoppingCart set num4 = 0 where userID = ?";
                break;
        }
        //创建sql命令对象
        ps=conn.prepareStatement(sql);
        ps.setInt(1,userID);
        //执行sql
        ps.execute();
        //遍历结果
        return checkShoppingCartDao(userID);
    }


}
