package by.sheshko.shop.dao;

import by.sheshko.shop.bean.User;

public interface UserDAO {
    void signIn(String login, String password) throws DAOException;

    void registration(String login, String password) throws DAOException;

    User getUserInfo(String login) throws DAOException;
}
