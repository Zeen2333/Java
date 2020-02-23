package sdu.zeen.dao;

import sdu.zeen.pojo.User;

public interface UserDao {
    User checkUserLoginDao(String user,String pwd);
}
