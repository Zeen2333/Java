package sdu.zeen.service.impl;

import sdu.zeen.dao.UserDao;
import sdu.zeen.dao.impl.UserDaoImpl;
import sdu.zeen.pojo.User;
import sdu.zeen.service.UserService;

public class UserServiceImpl implements UserService {
    //声明Dao层对象
    UserDao ud=new UserDaoImpl();
    //用户登录
    public User checkUserLoginService(String user, String pwd) {
        return ud.checkUserLoginDao(user,pwd);
    }
}
