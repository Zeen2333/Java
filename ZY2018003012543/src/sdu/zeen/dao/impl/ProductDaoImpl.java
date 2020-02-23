package sdu.zeen.dao.impl;

import sdu.zeen.Utils;
import sdu.zeen.dao.ProductDao;
import sdu.zeen.pojo.Product;
import sdu.zeen.pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    @Override
    public ArrayList<Product> checkProductDao() {
        //声明JDBC对象
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        //声明变量
        Product p=null;
        ArrayList<Product> ap= new ArrayList<>();
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn= Utils.getConnection();
            //创建sql命令
            String sql="select * from web201800301254_products";
            //创建sql命令对象
            ps=conn.prepareStatement(sql);
            //执行sql
            rs=ps.executeQuery();
            //遍历结果
            while (rs.next())
            {
                p=new Product(rs.getInt("ID"),rs.getString("name"),rs.getFloat("price"),rs.getString("pic"));
                ap.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            Utils.close(rs,ps,conn);
        }

        //返回结果
        return ap;
    }
}
