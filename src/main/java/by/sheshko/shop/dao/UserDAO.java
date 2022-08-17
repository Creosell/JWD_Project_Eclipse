package by.sheshko.shop.dao;

import by.sheshko.shop.bean.User;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;

    void registration(String login, String password, User user) throws DAOException;

    User editUserInfo(User user, String newPassword) throws DAOException;

}
