package sdu.zeen.service;

import sdu.zeen.pojo.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderService {
    ArrayList<Order> checkOrderService(int userID) throws SQLException;
    void addOrderService(int userID) throws SQLException;
}
