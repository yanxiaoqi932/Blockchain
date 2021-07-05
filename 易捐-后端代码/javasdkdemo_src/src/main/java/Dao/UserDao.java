package Dao;

import Beans.User;

public interface UserDao {
    int insert(User u);
    User getUserInfo(String ID);
}
