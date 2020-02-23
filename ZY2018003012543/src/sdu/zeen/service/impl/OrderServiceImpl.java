package sdu.zeen.service.impl;

import sdu.zeen.dao.OrderDao;
import sdu.zeen.dao.impl.OrderDaoImpl;
import sdu.zeen.pojo.Order;
import sdu.zeen.service.OrderService;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderServiceImpl implements OrderService {
    OrderDao od = new OrderDaoImpl();
    @Override
    public ArrayList<Order> checkOrderService(int userID) throws SQLException {
        return od.checkOrderDao(userID);
    }

    @Override
    public void addOrderService(int userID) throws SQLException {
        od.addOrderDao(userID);
    }
}
