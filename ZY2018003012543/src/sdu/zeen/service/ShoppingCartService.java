package sdu.zeen.service;

import sdu.zeen.pojo.ShoppingCart;

import java.sql.SQLException;

public interface ShoppingCartService {
    ShoppingCart checkShoppingCartService(int userID) throws SQLException;
    ShoppingCart addProductService(int ID,int userID) throws SQLException;
    ShoppingCart deleteProductService(int ID,int userID) throws SQLException;
}
