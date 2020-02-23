package sdu.zeen.service;

import sdu.zeen.pojo.User;

public interface UserService {
    User checkUserLoginService(String user, String pwd);
}
