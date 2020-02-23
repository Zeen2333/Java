package sdu.zeen.service.impl;

import sdu.zeen.dao.ShoppingCartDao;
import sdu.zeen.dao.impl.ShoppingCartDaoImpl;
import sdu.zeen.pojo.ShoppingCart;
import sdu.zeen.service.ShoppingCartService;

import java.sql.SQLException;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    ShoppingCartDao sc=new ShoppingCartDaoImpl();
    @Override
    public ShoppingCart checkShoppingCartService(int userID) throws SQLException {
        return sc.checkShoppingCartDao(userID);
    }

    @Override
    public ShoppingCart addProductService(int ID, int userID) throws SQLException {
        return sc.addProductDao(ID, userID);
    }

    @Override
    public ShoppingCart deleteProductService(int ID, int userID) throws SQLException {
        return sc.deleteProductDao(ID,userID);
    }
}
