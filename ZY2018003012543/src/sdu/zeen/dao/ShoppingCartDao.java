package sdu.zeen.dao;

import sdu.zeen.pojo.ShoppingCart;

import java.sql.SQLException;

public interface ShoppingCartDao {
    ShoppingCart checkShoppingCartDao(int userID) throws SQLException;
    ShoppingCart addProductDao(int ID,int userID) throws SQLException;
    ShoppingCart deleteProductDao(int ID,int userID) throws SQLException;
}
