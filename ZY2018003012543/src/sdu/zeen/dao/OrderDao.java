package sdu.zeen.dao;

import sdu.zeen.pojo.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDao {
    ArrayList<Order> checkOrderDao(int userID) throws SQLException;
    void addOrderDao(int userID) throws SQLException;
}
